package com.hl.schoolbar.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统用户id
     */
    @TableId(value = "sys_user_Id", type = IdType.AUTO)
    private Integer sysUserId;

    /**
     * 账户
     */
    private String sysUserAccount;

    /**
     * 用户名
     */
    private String sysUsername;

    /**
     * 加密后密码
     */
    private String password;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 创建时间
     */
    private Long createDate;

    /**
     * 是否删除1已删除0未删除
     */
    private Integer isDelete;


}
