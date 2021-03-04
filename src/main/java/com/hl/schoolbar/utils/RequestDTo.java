package com.hl.schoolbar.utils;

import com.hl.schoolbar.entity.Goods;
import com.hl.schoolbar.entity.Img;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * author: huangLong
 * date:2021/3/3 14:35
 * describe:对请求数据的封装
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTo {
    //商品
    Goods goods;
    //图片
    List<Img> imgList;
}
