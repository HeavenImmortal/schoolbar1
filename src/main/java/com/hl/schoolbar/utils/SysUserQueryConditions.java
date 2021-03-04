package com.hl.schoolbar.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author: huangLong
 * date:2021/2/23 11:09
 * describe: 系统用户查询条件
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class SysUserQueryConditions {
    private String sysUsername;//系统用户名
    private Integer roleId;//角色id
    private String phone;//电话号码
}
