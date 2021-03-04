package com.hl.schoolbar.mapper;

import com.hl.schoolbar.entity.Permission;
import com.hl.schoolbar.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hl.schoolbar.utils.SysUserQueryConditions;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 用户注册
     * @param sysUser
     * @return
     */
    int insSysUser(@Param("sysUser")SysUser sysUser);

    /**
     * 通过角色id查询权限
     * @param roleId
     * @return
     */
    List<Permission> selPermissionByRoleId(@Param("roleId")Integer roleId);

    /**
     * 通过账号查询用户
     * @param userAccount
     * @return
     */
    HashMap<String,Object> selSysUserByUserAccount(@Param("userAccount") String  userAccount);

    /**
     * 分页查询系统用户
     * @param sysUserQueryConditions
     * @return
     */
    List<HashMap<String,Object>> selPageSysUser(@Param("sysUserQueryConditions")SysUserQueryConditions sysUserQueryConditions);

    /**
     * 查询所有角色
     * @return
     */
    List<HashMap<String ,Object>> selAllRole();

    /**
     * 修改系统用户
     * @param sysUser
     * @return
     */
    int updSysUser(@Param("sysUser") SysUser sysUser);

    /**
     * 删除系统角色
     * @param id
     * @return
     */
    int delSysUserById(@Param("id") Integer id);
}
