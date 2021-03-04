package com.hl.schoolbar.mapper;

import com.hl.schoolbar.entity.Img;
import org.apache.ibatis.annotations.Param;

/**
 * author: huangLong
 * date:2021/2/26 9:58
 * describe:
 */

public interface CommonUtilMapper {

    /**
     * 上传图片
     * @param img
     * @return
     */
    int uploadFile(@Param("img") Img img);
}
