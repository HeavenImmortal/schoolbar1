package com.hl.schoolbar.service.impl;

import com.hl.schoolbar.entity.Role;
import com.hl.schoolbar.mapper.RoleMapper;
import com.hl.schoolbar.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hl.schoolbar.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 添加角色
     * @param role
     * @return
     */
    @Override
    public Result insRole(Role role) {
        try {
            //设置角色信息
            role.setIsDelete(0);
            int i = roleMapper.insRole(role);
            if(i==1){
                return Result.ok("添加成功");
            }else {
                return Result.error("添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public Result selAllRole() {
        List<Role> roleList = roleMapper.selAllRole();
        return Result.ok().put("roleList",roleList);
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @Override
    public Result delRoleById(Integer id) {
        try {
            int i = roleMapper.delRoleById(id);
            if(i==1){
                return Result.ok("删除成功");
            }else {
                return Result.error("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("删除失败");
        }
    }
}
