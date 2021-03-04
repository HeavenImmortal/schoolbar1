package com.hl.schoolbar.utils;

import lombok.Data;
import lombok.ToString;

/**
 * author: huangLong
 * date:2021/2/4 14:18
 * describe: 这是学校查询条件的封装
 */

@Data
@ToString
public class SchoolQueryConditions {
    //学校名称
    private String schoolName;
}
