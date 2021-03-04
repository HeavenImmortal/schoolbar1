package com.hl.schoolbar.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author: huangLong
 * date:2021/2/25 9:06
 * describe:商品查询
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GoodsQueryConditions {

    //商品名称
    private String goodsName;

    //类别id
    private Integer categoryId;

    //学校id
    private Integer schoolId;

    //用户id
    private Integer userId;

    //是否展示
    private Integer isShow;
}
