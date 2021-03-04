package com.hl.schoolbar.shiro.filter;

import com.hl.schoolbar.shiro.token.UserToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * author: huangLong
 * date:2021/2/26 13:57
 * describe:
 */

public class UserModularRealmAuthenticator extends ModularRealmAuthenticator {

    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 判断getRealms()是否返回为空
        assertRealmsConfigured();
        UserToken userToken = (UserToken) authenticationToken;
        String loginType = userToken.getLoginType();
        Collection<Realm> realms = getRealms();
        List<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            System.out.println("-------------------"+realm.getName());
            System.out.println("-------------------"+loginType);
            if (realm.getName().contains(loginType)) {
                System.out.println("====================================");
                typeRealms.add(realm);
            }
        }
        // 判断是单realm还是多realm
        if (typeRealms.size() == 1){
            return doSingleRealmAuthentication(typeRealms.get(0), userToken);
        }
        else{
            return doMultiRealmAuthentication(typeRealms, userToken);
        }
    }
}

