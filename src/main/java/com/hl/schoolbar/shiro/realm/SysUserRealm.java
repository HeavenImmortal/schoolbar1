package com.hl.schoolbar.shiro.realm;


import com.hl.schoolbar.entity.Permission;
import com.hl.schoolbar.entity.Role;
import com.hl.schoolbar.entity.SysUser;
import com.hl.schoolbar.entity.User;
import com.hl.schoolbar.mapper.SysUserMapper;
import com.hl.schoolbar.service.SysUserService;
import com.hl.schoolbar.service.UserService;
import com.hl.schoolbar.shiro.salt.byteSource.MyByteSource;
import com.hl.schoolbar.shiro.token.UserToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * author: huangLong
 * date:2020/12/4 16:09
 * describe:自定义realm
 */

public class SysUserRealm extends AuthorizingRealm {

    @Resource
    SysUserMapper sysUserMapper;


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("====================开始系统用户授权=====================");
        //获取身份信息
        String primaryPrincipal=(String) principalCollection.getPrimaryPrincipal();
        //通过账号查询用户
        HashMap<String,Object> sysUser = sysUserMapper.selSysUserByUserAccount(primaryPrincipal);
        //权限控制 1.页面中使用<shiro></shiro>标签 2.代码中控制 3.注解 @RequiresRoles("admin") @RequiresPermissions("")
        //根据角色身份信息获取权限信息
        List<Permission> permissions = sysUserMapper.selPermissionByRoleId(Integer.parseInt(sysUser.get("roleId").toString()));
        if(!CollectionUtils.isEmpty(permissions)){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
                simpleAuthorizationInfo.addRole(sysUser.get("roleId").toString());
                permissions.forEach(permission -> {
                    System.out.println(permission.getPermissionsName());
                    //设置角色对应的权限授权
                    simpleAuthorizationInfo.addStringPermission(permission.getPermissionsUrl());
                });
            return  simpleAuthorizationInfo;
        }
        return null;
    }


    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("=============开始系统用户认证认证================");
        UserToken userToken = (UserToken)token;
        String sysUserAccount = (String) userToken.getPrincipal();
        HashMap<String,Object> sysUser = sysUserMapper.selSysUserByUserAccount(sysUserAccount);
        if(!ObjectUtils.isEmpty(sysUser)){
            return (AuthenticationInfo)new SimpleAuthenticationInfo(sysUser.get("sysUserAccount").toString(),sysUser.get("password").toString(), new MyByteSource(sysUser.get("salt").toString()),this.getName());
        }

        return null;
    }
}
