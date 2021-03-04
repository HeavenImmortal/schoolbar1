package com.hl.schoolbar.utils;

import lombok.Data;
import lombok.ToString;

/**
 * author: huangLong
 * date:2021/2/4 14:15
 * describe:这是分页工具类，方便前端给后台传递分页数据
 */

@Data
@ToString
public class PageBuilder {
    //当前页数
    private Integer pageNum;
    //每页大小
    private Integer pageSize;

    //学校查询条件
    private SchoolQueryConditions schoolQueryConditions;

    //系统用户查询条件
    private SysUserQueryConditions sysUserQueryConditions;

    //用户查询条件
    private UserQueryConditions userQueryConditions;

    //商品查询条件
    private GoodsQueryConditions goodsQueryConditions;

    //贴子查询条件
    private PostQueryConditions postQueryConditions;
}
