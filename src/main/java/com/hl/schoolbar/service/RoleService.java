package com.hl.schoolbar.service;

import com.hl.schoolbar.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hl.schoolbar.utils.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
public interface RoleService extends IService<Role> {

    /**
     * 添加角色
     * @param role
     * @return
     */
    Result insRole(Role role);

    /**
     * 查询所有角色
     * @return
     */
    Result selAllRole();

    /**
     * 删除角色
     * @param id
     * @return
     */
    Result delRoleById(Integer id);

}
