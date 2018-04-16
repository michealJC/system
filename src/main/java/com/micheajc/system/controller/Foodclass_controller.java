package com.micheajc.system.controller;


import com.micheajc.system.bean.sys_foodclass;
import com.micheajc.system.service.Foodclass_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foodclass")
public class Foodclass_controller {

    @Autowired
    Foodclass_service foodclass_service;
    @RequestMapping("/getfoodclass")
    public List<sys_foodclass> getfoodclass(){
        return foodclass_service.getfoodclass();
    }
}
