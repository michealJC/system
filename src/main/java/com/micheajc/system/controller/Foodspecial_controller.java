package com.micheajc.system.controller;


import com.micheajc.system.bean.sys_foodspecial;
import com.micheajc.system.service.Foodspecial_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foodspecial")
public class Foodspecial_controller {

    @Autowired
    private Foodspecial_service foodspecial_service;

    @RequestMapping("/getfoodspecial")
    @ResponseBody
    public List<sys_foodspecial> getfoodspeciallist(){
        return foodspecial_service.getfoodspeciallist();
    }
}
