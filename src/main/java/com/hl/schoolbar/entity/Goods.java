package com.hl.schoolbar.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2021-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品描述
     */
    private String goodsDescribe;

    /**
     * 商品类别
     */
    private Integer categoryId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * qq
     */
    private String qqNumber;

    /**
     * 电话
     */
    private String phone;

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
     * 是否展示
     */
    private Integer isShow;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 图片
     */
    List<Img> imgList;
}
