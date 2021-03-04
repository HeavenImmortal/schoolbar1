package com.hl.schoolbar.mapper;

import com.hl.schoolbar.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hl.schoolbar.utils.UserQueryConditions;
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
public interface UserMapper extends BaseMapper<User> {

    /**
     * 分页查询用户
     * @param userQueryConditions
     * @return
     */
    List<HashMap<String,Object>> selPageUser(@Param("userQueryConditions")UserQueryConditions userQueryConditions);

    /**
     * 通过账号查询用户
     * @param userAccount
     * @return
     */
    HashMap<String ,Object> selUserByUserAccount(@Param("userAccount")String userAccount);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insUser(@Param("user")User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updUser(@Param("user")User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delUserById(@Param("id")Integer id);

    /**
     * 修改密码
     * @param id
     * @param password
     * @param salt
     * @return
     */
    int updUserPassword(@Param("id")Integer id,
                        @Param("password")String password,
                        @Param("salt")String salt);

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    HashMap<String ,Object> selUserById(@Param("id")Integer id);

    /**
     * 查询所有学校
     * @return
     */
    List<HashMap<String,Object>> selAllSchool();
}
