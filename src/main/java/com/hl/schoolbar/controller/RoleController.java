package com.hl.schoolbar.controller;


import com.hl.schoolbar.entity.Role;
import com.hl.schoolbar.service.RoleService;
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
@RequestMapping("/role")
@Api(tags = "角色权限管理")
public class RoleController {

    @Resource
    private RoleService roleServiceImpl;


    /**
     * 添加角色
     * @param role
     * @return
     */
    @ApiOperation(value="添加角色", notes="post请求方式，json格式传递数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "roleId", value = "角色id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "roleName", value = "角色名称", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "roleDescribe", value = "角色描述", required = false, dataType = "String")
    })
    @RequestMapping(value = "/insRole",method = RequestMethod.POST)
    public Result insRole(@RequestBody Role role){
        return roleServiceImpl.insRole(role);
    }

    /**
     * 查询角色
     * @param
     * @return
     */
    @ApiOperation(value="查询角色", notes="get请求方式")
    @ApiImplicitParams({
    })

    @RequestMapping(value = "/selAllRole",method = RequestMethod.GET)
    public Result selAllRole(){
        return roleServiceImpl.selAllRole();
    }

    /**
     * 删除角色
     * @param
     * @return
     */
    @ApiOperation(value="删除角色", notes="get请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "角色id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/delRoleById",method = RequestMethod.GET)
    public Result delRoleById(@RequestParam("id") Integer id){
        return roleServiceImpl.delRoleById(id);
    }

    /**
     * 查询角色权限
     * @param
     * @return
     */
    @ApiOperation(value="查询角色权限", notes="get请求方式")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "角色id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/selPermissionByRoleId",method = RequestMethod.GET)
    public Result selPermissionByRoleId(@RequestParam("id") Integer id){
        return null;
    }

    /**
     * 修改角色权限
     * @param
     * @return
     */
    @ApiOperation(value="修改角色权限", notes="post请求方式,json传递数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "角色id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/updRolePermission",method = RequestMethod.GET)
    public Result updRolePermission(){
        return null;
    }


}
