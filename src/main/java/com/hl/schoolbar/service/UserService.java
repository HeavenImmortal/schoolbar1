package com.hl.schoolbar.service;

import com.hl.schoolbar.entity.User;
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
public interface UserService extends IService<User> {

    /**
     * 分页查询用户
     * @param pageBuilder
     * @return
     */
    Result selPageUser(PageBuilder pageBuilder);

    /**
     * 通过用户账户查询用户
     * @param userAccount
     * @return
     */
    Result selUserByUserAccount(String userAccount);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Result insUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    Result updUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Result delUserById(Integer id);

    /**
     * 修改密码
     * @param id
     * @param odlPassword
     * @param newPassword
     * @return
     */
    Result updUserPassword(Integer id,String odlPassword,String newPassword);

    /**
     * 查询所有学校
     * @return
     */
    Result selAllSchool();
}
