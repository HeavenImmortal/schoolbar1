package com.hl.schoolbar.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * author: huangLong
 * date:2021/2/26 13:50
 * describe:
 */

public class UserToken  extends UsernamePasswordToken {
    private static final long serialVersionUID = 1L;
    public static final String ReceptionType="Reception";
    public static final String AdminType="User";
    private String loginType;

    public UserToken(final String username, final String password, final Boolean rememberMe, String loginType) {
        super(username, password,rememberMe);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
