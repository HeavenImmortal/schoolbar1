package com.hl.schoolbar.config;


import com.hl.schoolbar.shiro.cache.RedisCacheManager;
import com.hl.schoolbar.shiro.filter.MyHttpAuthenticationFilter;
import com.hl.schoolbar.shiro.filter.UserModularRealmAuthenticator;
import com.hl.schoolbar.shiro.realm.SysUserRealm;
import com.hl.schoolbar.shiro.realm.FrontUserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.*;

/**
 * author: huangLong
 * date:2020/12/4 15:50
 * describe:用来整合shiro的配置类
 */

@Configuration
public class ShiroConfig {

    @Resource
    RedisTemplate redisTemplate;

    @Bean
    public RedisCacheManager getRedisCacheManager(){
        return new RedisCacheManager();
    }

    //创建ShiroFilter
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login/**","anon");
        filterMap.put("/school/**", "authc"); // 主要通过注解方式校验权限
        chainDefinition.addPathDefinitions(filterMap);
        return chainDefinition;
    }
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager,
                                                            ShiroFilterChainDefinition shiroFilterChainDefinition){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, Filter> filterMap = shiroFilterFactoryBean.getFilters();
        filterMap.put("authc", new MyHttpAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        Map<String,String > map = shiroFilterChainDefinition.getFilterChainMap();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //创建Shiro安全管理器
    @Bean
    public DefaultWebSecurityManager securityManager(FrontUserRealm frontUserRealm, SysUserRealm sysUserRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm
        securityManager.setAuthenticator(modularRealmAuthenticator());
        List<Realm> realms = new ArrayList<>();
        realms.add(frontUserRealm);
        realms.add(sysUserRealm);
        securityManager.setRealms(realms);
        return securityManager;
    }

    //创建自定义realm
    /**
     * 后台管理人员realm
     * @return
     */
    @Bean
    @Primary
    public SysUserRealm sysUserRealm(){
        SysUserRealm sysUserRealm = new SysUserRealm();
        //修改凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数
        credentialsMatcher.setHashIterations(1024);
        sysUserRealm.setCredentialsMatcher(credentialsMatcher);
        sysUserRealm.setCacheManager(getRedisCacheManager());
        sysUserRealm.setCachingEnabled(true);//全局开启缓存管理
        //sysUserRealm.setAuthenticationCachingEnabled(true);//开启认证缓存
        //sysUserRealm.setAuthenticationCacheName("authenticationCache");
        sysUserRealm.setAuthorizationCachingEnabled(true);//开启授权缓存
        sysUserRealm.setAuthorizationCacheName("authorizationCache");
        return sysUserRealm;
    }

    /**
     * 前端用户realm
     * @return
     */
    @Bean
    public FrontUserRealm userRealm(){
        FrontUserRealm frontUserRealm = new FrontUserRealm();
        //修改凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数
        credentialsMatcher.setHashIterations(1024);
        frontUserRealm.setCredentialsMatcher(credentialsMatcher);
        frontUserRealm.setCacheManager(getRedisCacheManager());
        frontUserRealm.setCachingEnabled(true);//全局开启缓存管理
        //userRealm.setAuthenticationCachingEnabled(true);//开启认证缓存
        //userRealm.setAuthenticationCacheName("authenticationCache");
        frontUserRealm.setAuthorizationCachingEnabled(true);//开启授权缓存
        frontUserRealm.setAuthorizationCacheName("authorizationCache");
        return frontUserRealm;
    }

    /**
     * Realm管理，针对多realm
     * @return
     */
    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator(){
        UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }

}
