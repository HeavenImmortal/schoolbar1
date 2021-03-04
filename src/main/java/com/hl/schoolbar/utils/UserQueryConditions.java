package com.hl.schoolbar.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author: huangLong
 * date:2021/2/24 10:24
 * describe:用户查询条件
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserQueryConditions {
    //用户名称
    private String username;
    //学校id
    private Integer schoolId;
    //电话号码
    private String phone;

}
