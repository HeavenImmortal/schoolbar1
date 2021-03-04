package com.hl.schoolbar.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author: huangLong
 * date:2021/2/26 10:34
 * describe:贴子查询条件
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostQueryConditions {

    //用户id
    private Integer userId;

    //学校id
    private Integer schoolId;

    //标题
    private String title;

    //内容
    private String content;
}
