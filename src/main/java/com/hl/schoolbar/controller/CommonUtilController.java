package com.hl.schoolbar.controller;

import com.hl.schoolbar.service.CommonUtilService;
import com.hl.schoolbar.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * author: huangLong
 * date:2021/2/26 9:50
 * describe:
 */

@Api(tags = "公共工具")
@Controller
@RestController
@RequestMapping("/utils")
public class CommonUtilController {

    @Resource
    private CommonUtilService commonUtilServiceImpl;

    @ApiOperation(value="上传文件", notes="post请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "file", value = "文件", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public Result uploadFile(MultipartFile file){
        return commonUtilServiceImpl.uploadFile(file);
    }
}
