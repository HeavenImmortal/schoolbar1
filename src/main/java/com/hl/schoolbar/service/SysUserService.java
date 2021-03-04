package com.hl.schoolbar.service;

import com.hl.schoolbar.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    Result insSysUser(SysUser sysUser);

    /**
     * 分页查询系统用户
     * @param pageBuilder
     * @return
     */
    Result selPageSysUser(PageBuilder pageBuilder);

    /**
     * 查询所有角色
     * @return
     */
    Result selAllRole();

    /**
     * 修改系统用户
     * @param sysUser
     * @return
     */
    Result updSysUser(SysUser sysUser);

    /**
     * 删除系统用户
     * @param id
     * @return
     */
    Result delSysUserById(Integer id);

}
