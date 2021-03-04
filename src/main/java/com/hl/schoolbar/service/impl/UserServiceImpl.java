package com.hl.schoolbar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hl.schoolbar.entity.User;
import com.hl.schoolbar.mapper.UserMapper;
import com.hl.schoolbar.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.Result;
import com.hl.schoolbar.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 分页查询用户
     * @param pageBuilder
     * @return
     */
    @Override
    public Result selPageUser(PageBuilder pageBuilder) {
        PageHelper.startPage(pageBuilder.getPageNum(),pageBuilder.getPageSize());
        List<HashMap<String,Object>> userList = userMapper.selPageUser(pageBuilder.getUserQueryConditions());
        PageInfo<HashMap<String,Object>> pageInfo = new PageInfo<>(userList);
        return Result.ok().put("pageInfo",pageInfo);
    }

    /**
     * 通过账户查询用户
     * @param userAccount
     * @return
     */
    @Override
    public Result selUserByUserAccount(String userAccount) {
        HashMap<String ,Object> user = userMapper.selUserByUserAccount(userAccount);
        return Result.ok().put("user",user);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public Result insUser(User user) {
        try{
            if(userMapper.selUserByUserAccount(user.getUserAccount())!=null){
                return Result.error("该账号已存在");
            }
            //设置数据
            user.setIsDelete(0);
            user.setCreateDate(System.currentTimeMillis());
            user.setAvatar("https://heavenimmortal.oss-cn-chengdu.aliyuncs.com/img/avatar.png");
            //对密码进行加密处理
            String salt = SaltUtils.getSalt(16);
            user.setSalt(salt);
            Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
            //保存经过加密后的密码
            String newPassword = md5Hash.toHex();
            user.setPassword(newPassword);

            int i = userMapper.insUser(user);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Override
    public Result updUser(User user) {
        try{
            int i = userMapper.updUser(user);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("修改失败");
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public Result delUserById(Integer id) {
        try{
            int i = userMapper.delUserById(id);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("修改失败");
        }
    }

    @Override
    public Result updUserPassword(Integer id,String odlPassword,String newPassword) {
        try{
            HashMap<String ,Object> user = userMapper.selUserById(id);
            if(user!=null){
                Md5Hash md5 = new Md5Hash(odlPassword,user.get("salt").toString(),1024);
                String tempPassword = md5.toHex();
                if(!tempPassword.equals(user.get("password").toString())){
                    return Result.error("原密码不正确");
                }
            }else {
                return Result.error("没有该用户");
            }
            //对密码进行加密处理
            String salt = SaltUtils.getSalt(16);
            Md5Hash md5Hash = new Md5Hash(newPassword,salt,1024);
            //保存经过加密后的密码
            newPassword = md5Hash.toHex();
            int i = userMapper.updUserPassword(id,newPassword,salt);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("修改失败");
        }
    }

    /**
     * 查询所有学校
     * @return
     */
    @Override
    public Result selAllSchool() {
        List<HashMap<String ,Object>> schoolList = userMapper.selAllSchool();
        return Result.ok().put("schoolList",schoolList);
    }
}
