package com.hl.schoolbar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * author: huangLong
 * date:2021/2/26 10:04
 * describe:
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Img {

    private Integer imgId;

    private String imageUrl;
}
