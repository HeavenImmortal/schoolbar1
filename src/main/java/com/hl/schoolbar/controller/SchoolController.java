package com.hl.schoolbar.controller;


import com.hl.schoolbar.entity.School;
import com.hl.schoolbar.service.SchoolService;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/school")
@Api(tags = "学校管理")

public class SchoolController {

    @Resource
    private SchoolService schoolServiceImpl;

    /**
     * 分页查询学校
     */
    @ApiOperation(value="分页查询所有学校", notes="post请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "目标页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "每页大小", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "schoolName", value = "学校名称", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/selPageSchool",method = RequestMethod.POST)
    public Result selPageSchool(@RequestBody PageBuilder pageBuilder){
        return schoolServiceImpl.selPageSchool(pageBuilder);
    }

    /**
     * 添加学校
     * @param school
     * @return
     */
    @ApiOperation(value="添加学校", notes="post请求方式，json格式传递数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "schoolName", value = "学校名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "schoolDescribe", value = "学校描述", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "address", value = "学校地址", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "imgId", value = "校徽图片id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/insSchool",method = RequestMethod.POST)
    public Result insSchool(@RequestBody School school){

        return schoolServiceImpl.insSchool(school);
    }

    /**
     * 修改学校
     * @param school
     * @return
     */
    @ApiOperation(value="修改学校", notes="post请求方式，json格式传递数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "schoolId", value = "学校id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "schoolName", value = "学校名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "schoolDescribe", value = "学校描述", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "address", value = "学校地址", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "imgId", value = "校徽图片id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/updSchool",method = RequestMethod.POST)
    public Result updSchool(@RequestBody School school){

        return schoolServiceImpl.updSchool(school);
    }

    /**
     * 删除学校
     * @param id
     * @return
     */
    @ApiOperation(value="删除学校", notes="get请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "学校id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/delSchoolById",method = RequestMethod.GET)
    public Result delSchoolById(Integer id){
        System.out.println(id);
        return schoolServiceImpl.delSchoolById(id);
    }
}
