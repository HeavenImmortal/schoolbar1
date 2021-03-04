package com.hl.schoolbar.controller;

import com.hl.schoolbar.entity.SysUser;
import com.hl.schoolbar.service.SysUserService;
import com.hl.schoolbar.service.UserService;
import com.hl.schoolbar.shiro.token.UserToken;
import com.hl.schoolbar.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;

/**
 * author: huangLong
 * date:2021/2/5 14:14
 * describe:
 */

@CrossOrigin
@RestController
@RequestMapping("/login")
@Api(tags = "用户登录注册退出")
public class LoginController {

    @Resource
    private SysUserService sysUserServiceImpl;
    @Resource
    private UserService userServiceImpl;

    /**
     * 用来处理身份认证
     * @param userAccount
     * @param password
     * @return
     */
    @ApiOperation(value="系统管理人员登录", notes="get请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userAccount", value = "用户账号", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "password", value = "用户密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/sysUserLogin",method = RequestMethod.GET)
    public Result index(@RequestParam("userAccount") String userAccount, @RequestParam("password") String password){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try{
            //将用户名密码封装成token
            subject.login(new UserToken(userAccount,password,true,"SysUserRealm"));
            Serializable tokenId = subject.getSession().getId();
            System.out.println("======================"+tokenId);
            return Result.ok().put("token",tokenId);
        }catch (UnknownAccountException e){
            e.printStackTrace();
            return Result.error("账号错误");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return Result.error("密码错误");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("系统错误");
        }
    }

    /**
     * 退出
     * @return
     */
    @ApiOperation(value="退出", notes="get请求")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.ok();
    }

    /**
     * 用户注册
     * @param sysUser
     * @return
     */
    @ApiOperation(value="注册", notes="post请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userAccount", value = "用户账号", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "password", value = "用户密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result register(@RequestBody SysUser sysUser){
        try{
            return sysUserServiceImpl.insSysUser(sysUser);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("注册失败");
        }
    }


    /**
     * 用来处理身份认证
     * @param userAccount
     * @param password
     * @return
     */
    @ApiOperation(value="用户登录", notes="get请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userAccount", value = "用户账号", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "password", value = "用户密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    public Result userLogin(@RequestParam("userAccount") String userAccount, @RequestParam("password") String password){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try{
            //将用户名密码封装成token
            subject.login(new UserToken(userAccount,password,true,"FrontUserRealm"));
            Serializable tokenId = subject.getSession().getId();
            System.out.println("======================"+tokenId);
            Result result = userServiceImpl.selUserByUserAccount(userAccount);
            result.put("token",tokenId);
            return result;
        }catch (UnknownAccountException e){
            e.printStackTrace();
            return Result.error("账号错误");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return Result.error("密码错误");
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("系统错误");
        }
    }
}
