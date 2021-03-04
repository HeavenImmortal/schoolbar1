package com.hl.schoolbar.shiro.realm;

import com.hl.schoolbar.mapper.UserMapper;
import com.hl.schoolbar.service.UserService;
import com.hl.schoolbar.shiro.salt.byteSource.MyByteSource;
import com.hl.schoolbar.shiro.token.UserToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * author: huangLong
 * date:2021/2/26 11:23
 * describe:用户Realm
 */

public class FrontUserRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
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
        System.out.println("================开始前端用户认证=====================");
        UserToken userToken = (UserToken)token;

        String userAccount = (String) userToken.getPrincipal();
        HashMap<String ,Object> user = userMapper.selUserByUserAccount(userAccount);
        if(!ObjectUtils.isEmpty(user)){
            return (AuthenticationInfo) new SimpleAuthenticationInfo(user.get("userAccount").toString(),user.get("password").toString(), new MyByteSource(user.get("salt").toString()),this.getName());
        }
        return null;
    }
}
