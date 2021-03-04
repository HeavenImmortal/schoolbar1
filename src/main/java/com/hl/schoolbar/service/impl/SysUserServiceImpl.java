package com.hl.schoolbar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hl.schoolbar.entity.SysUser;
import com.hl.schoolbar.mapper.SysUserMapper;
import com.hl.schoolbar.service.SysUserService;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 添加系统用户
     * @param sysUser
     * @return
     */
    @Override
    public Result insSysUser(SysUser sysUser) {
        try{
            if(sysUserMapper.selSysUserByUserAccount(sysUser.getSysUserAccount())!=null){
                return Result.error("该账号已存在");
            }
            //基础数据设置
            sysUser.setIsDelete(0);
            sysUser.setCreateDate(System.currentTimeMillis());

            //对密码进行加密处理
            String salt = SaltUtils.getSalt(16);
            sysUser.setSalt(salt);
            Md5Hash md5Hash = new Md5Hash(sysUser.getPassword(),salt,1024);
            //保存经过加密后的密码
            String newPassword = md5Hash.toHex();
            sysUser.setPassword(newPassword);

            int i = sysUserMapper.insSysUser(sysUser);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    /**
     * 分页查询系统用户
     * @param pageBuilder
     * @return
     */
    @Override
    public Result selPageSysUser(PageBuilder pageBuilder) {
        PageHelper.startPage(pageBuilder.getPageNum(),pageBuilder.getPageSize());
        List<HashMap<String ,Object>> sysUserList = sysUserMapper.selPageSysUser(pageBuilder.getSysUserQueryConditions());
        PageInfo<HashMap<String ,Object>> pageInfo = new PageInfo<>(sysUserList);
        return Result.ok().put("pageInfo",pageInfo);
    }

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public Result selAllRole() {
        List<HashMap<String ,Object>> roleList = sysUserMapper.selAllRole();

        return Result.ok().put("roleList",roleList);
    }

    /**
     * 修改系统用户
     * @param sysUser
     * @return
     */
    @Override
    public Result updSysUser(SysUser sysUser) {
        try{
            HashMap<String ,Object> tempSysUser = sysUserMapper.selSysUserByUserAccount(sysUser.getSysUserAccount());
            if(tempSysUser!=null){
                if(tempSysUser.get("sysUserId").toString() != sysUser.getSysUserId().toString() )
                return Result.error("该账号已存在");
            }
            int i = sysUserMapper.updSysUser(sysUser);
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
     * 删除系统用户
     * @param id
     * @return
     */
    @Override
    public Result delSysUserById(Integer id) {
        try{
            int i = sysUserMapper.delSysUserById(id);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("删除失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("删除失败");
        }
    }
}
