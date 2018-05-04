package com.micheajc.system.controller;


import com.micheajc.system.bean.loginuser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {

    @RequestMapping(value = "/login")
    public String login(){
        return "backstage";
    }

    @RequestMapping(value = "/loginsub")
    public String loginsub(loginuser login){
        try {
            Subject subject= SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(login.getUsername(),login.getPassword());
            subject.login(usernamePasswordToken);
            return "redirect:/foodMunu/menu.html";
        }catch (Exception e){
            return "redirect:backstage.html";
        }
    }
}
