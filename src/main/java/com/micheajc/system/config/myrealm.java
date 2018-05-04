package com.micheajc.system.config;

import com.micheajc.system.mapper.Loginmapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class myrealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    @Autowired
    private Loginmapper loginmapper;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=authenticationToken.getPrincipal().toString();
        System.out.println(username+"ddddddddddddddddddddd");
        String password=loginmapper.getpasswordbyusername(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(username,password,"myrrealm");

        return simpleAuthenticationInfo;
    }
}
