package com.micheajc.system.config;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroSpring {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filterChainDefinitionMap =new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/loginsub","anon");
        filterChainDefinitionMap.put("/foodMunu/menu.html","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl("/login");

        return shiroFilterFactoryBean;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    @Bean
    public myrealm ttrealm(){
        myrealm my=new myrealm();
        my.setCredentialsMatcher(hashedCredentialsMatcher());
        return my;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(ttrealm());
        return defaultWebSecurityManager;
    }
}
