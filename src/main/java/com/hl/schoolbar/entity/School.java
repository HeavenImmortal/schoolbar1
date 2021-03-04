package com.hl.schoolbar.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("tb_school")
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学校id
     */
    @TableId(value = "school_id", type = IdType.AUTO)
    private Integer schoolId;

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 学校描述
     */
    private String schoolDescribe;

    /**
     * 学校地址
     */
    private String address;

    /**
     * 图片id
     */
    private Integer imgId;

    /**
     * 创建时间
     */
    private String  createDate;

    /**
     * 是否删除1表示已删除0表示未删除
     */
    private Integer isDelete;


}
