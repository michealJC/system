package com.micheajc.system.controller;


import com.micheajc.system.bean.loginuser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login {

    @RequestMapping(value = "/login")
    public String login(){
        return "backstage";
    }

    @RequestMapping(value = "/loginsub")
    public String loginsub(loginuser login){
        System.out.println(login.toString()+"----------------"+login.getUsername()+login.getPassword());
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(login.getUsername(),login.getPassword());
        subject.login(usernamePasswordToken);
        return "demo1";
    }
}
