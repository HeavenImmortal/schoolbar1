package com.hl.schoolbar.service;

import com.hl.schoolbar.utils.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * author: huangLong
 * date:2021/2/26 9:17
 * describe:公共工具方法
 */

public interface CommonUtilService {

    /**
     * 上传文件
     * @param file
     * @return
     */
    Result uploadFile(MultipartFile file);
}
