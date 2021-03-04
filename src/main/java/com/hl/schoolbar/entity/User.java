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
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_Id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 账户
     */
    private String userAccount;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 加盐后密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 学校
     */
    private Integer schoolId;

    /**
     * 邮箱
     */
    private String email;

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
     * 是否注销1表示注销0表示未注销
     */
    private Integer isDelete;


}
