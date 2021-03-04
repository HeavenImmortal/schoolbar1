package com.hl.schoolbar.mapper;

import com.hl.schoolbar.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> selAllRole();

    /**
     * 添加角色
     * @param role
     * @return
     */
    int insRole(@Param("role")Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    int delRoleById(@Param("id")Integer id);

}
