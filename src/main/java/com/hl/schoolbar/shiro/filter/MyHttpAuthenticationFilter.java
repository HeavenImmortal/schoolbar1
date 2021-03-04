package com.hl.schoolbar.shiro.filter;

import com.hl.schoolbar.shiro.token.UserToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MyHttpAuthenticationFilter  extends FormAuthenticationFilter {
    /**
     * @desc  跨域时，先发送option请求，option是不携带cookie信息的，但是也被shiro拦截了导致不通过，无法发送正常请求
     *        因此需要将OPTION放行。
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }else {
                String token = ((HttpServletRequest) request).getHeader("Authorization");
                System.out.println("================"+token);
                if (null == token||"".equals(token)) {
                    System.out.println("-------------------token为空");
                    return false;
                }
                //验证token的真实性
                try {
//                    TokenUtil.getTokenBody(token);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("----------------token有问题");
                    return false;
                }
                return true;
            }
        }

        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
            throws Exception {
        WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

    @Override
    protected UserToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String loginType = request.getParameter("loginType");
        System.out.println("===================================="+loginType);
        if("sysUser".equals(loginType)){
            return new UserToken(username, password, true,"SysUserRealm");
        } else {
            return new UserToken(username, password, true,"UserRealm");
        }
    }
}
