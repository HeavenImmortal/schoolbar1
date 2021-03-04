package com.hl.schoolbar.controller;


import com.hl.schoolbar.entity.User;
import com.hl.schoolbar.service.UserService;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userServiceImpl;

    /**
     * 分页查询用户
     * @param pageBuilder
     * @return
     */
    @ApiOperation(value="分页查询用户", notes="post请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "目标页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "每页大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "username", value = "用户名称", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "schoolId", value = "学校id", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "phone", value = "电话号码", required = false, dataType = "String")
    })
    @RequestMapping(value = "/selPageUser",method = RequestMethod.POST)
    public Result selPageUser(@RequestBody PageBuilder pageBuilder){

        return userServiceImpl.selPageUser(pageBuilder);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value="添加用户", notes="post请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userAccount", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "username", value = "名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "schoolId", value = "学校id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "email", value = "邮箱", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "phone", value = "电话号码", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "sex", value = "性别", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "age", value = "年龄", required = false, dataType = "String")
    })
    @RequestMapping(value = "/insUser",method = RequestMethod.POST)
    public Result insUser(@RequestBody User user){
        return userServiceImpl.insUser(user);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @ApiOperation(value="修改用户", notes="post请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "username", value = "名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "schoolId", value = "学校id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "email", value = "邮箱", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "phone", value = "电话号码", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "sex", value = "性别", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "age", value = "年龄", required = false, dataType = "String")
    })
    @RequestMapping(value = "/updUser",method = RequestMethod.POST)
    public Result updUser(@RequestBody User user){
        return userServiceImpl.updUser(user);
    }

    /**
     * 修改用户
     * @param id
     * @return
     */
    @ApiOperation(value="删除用户", notes="get请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "用户id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/delUserById",method = RequestMethod.GET)
    public Result delUserById(Integer id){
        return userServiceImpl.delUserById(id);
    }

    /**
     * 修改密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @ApiOperation(value="修改密码", notes="get请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "oldPassword", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "newPassword", value = "用户id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/updUserPassword",method = RequestMethod.GET)
    public Result updUserPassword(Integer id,String oldPassword,String newPassword){
        return userServiceImpl.updUserPassword(id, oldPassword,newPassword);
    }

    @ApiOperation(value="查询学校", notes="方便通过学校查询用户,添加修改用户时设置学校")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/selAllSchool",method = RequestMethod.GET)
    public Result selAllSchool(){
        return userServiceImpl.selAllSchool();
    }
}
