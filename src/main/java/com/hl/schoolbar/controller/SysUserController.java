package com.hl.schoolbar.controller;


import com.hl.schoolbar.entity.SysUser;
import com.hl.schoolbar.service.SysUserService;
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
@Api(tags = "系统用户管理")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    SysUserService sysUserServiceImpl;

    /**
     * 添加新用户
     * @param sysUser
     * @return
     */
    @ApiOperation(value="添加新用户", notes="post请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "sysUserAccount", value = "用户账号", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "password", value = "用户密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "sysUserId", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "sysUsername", value = "用户名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "roleId", value = "角色id", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "phone", value = "电话号码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "sex", value = "性别", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "age", value = "年龄", required = false, dataType = "Integer"),
    })
    @RequestMapping(value = "/insSysUser",method = RequestMethod.POST)
    public Result insSysUser(@RequestBody SysUser sysUser){
        try{
            return sysUserServiceImpl.insSysUser(sysUser);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("注册失败");
        }
    }

    @ApiOperation(value="分页查询系统用户", notes="post请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "目标页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "每页大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "sysUsername", value = "用户名称", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "roleId", value = "角色id", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "phone", value = "电话号码", required = false, dataType = "String"),
    })
    @RequestMapping(value = "/selPageSysUser",method = RequestMethod.POST)
    public Result selPageSysUser(@RequestBody PageBuilder pageBuilder){
        return sysUserServiceImpl.selPageSysUser(pageBuilder);
    }

    /**
     * 查询所有角色
     * @return
     */
    @ApiOperation(value="查询所有角色", notes="get请求方式")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/selAllRole",method = RequestMethod.GET)
    public Result selAllRole(){
        return sysUserServiceImpl.selAllRole();
    }

    /**
     * 修改系统用户
     * @param sysUser
     * @return
     */
    @ApiOperation(value="修改系统用户", notes="post请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "sysUserId", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "sysUsername", value = "用户名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "roleId", value = "角色id", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "phone", value = "电话号码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "sex", value = "性别", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "age", value = "年龄", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/updSysUser",method = RequestMethod.POST)
    public Result updSysUser(@RequestBody SysUser sysUser){
        System.out.println(sysUser);
        return sysUserServiceImpl.updSysUser(sysUser);
    }

    /**
     * 删除系统用户
     * @param id
     * @return
     */
    @ApiOperation(value="删除系统用户", notes="get请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "用户id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/delSysUserById",method = RequestMethod.GET)
    public Result delSysUserById(Integer id){
        System.out.println(id);
        return sysUserServiceImpl.delSysUserById(id);
    }
}
