package com.hl.schoolbar.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 贴子id
     */
    private Integer postId;

    /**
     * 贴子标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 内容mkd
     */
    private String contentMkd;

    /**
     * 内容html
     */
    private String contentHtml;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 学校id
     */
    private Integer schoolId;

    /**
     * 创建时间
     */
    private Long createDate;


    /**
     * 是否删除
     */
    private Integer isDelete;


}
