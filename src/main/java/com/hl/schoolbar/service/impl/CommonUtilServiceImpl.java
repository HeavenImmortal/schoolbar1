package com.hl.schoolbar.service.impl;

import com.hl.schoolbar.entity.Img;
import com.hl.schoolbar.mapper.CommonUtilMapper;
import com.hl.schoolbar.service.CommonUtilService;
import com.hl.schoolbar.utils.AliYunOssUtils;
import com.hl.schoolbar.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


/**
 * author: huangLong
 * date:2021/2/26 9:18
 * describe:
 */

@Service
public class CommonUtilServiceImpl  implements CommonUtilService {

    @Resource
    private CommonUtilMapper commonUtilMapper;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @Override
    public Result uploadFile(MultipartFile file) {
        AliYunOssUtils util = new AliYunOssUtils();
        //上传成功返回完整路径的url
        String url = util.uploadFile(file);

        System.out.println("==============="+url);
        Img img = new Img();
        img.setImageUrl(url);

        int i = commonUtilMapper.uploadFile(img);
        if(i==1){
            return Result.ok().put("img",img);
        }else {
            return Result.error("上传图片失败");
        }

    }
}
