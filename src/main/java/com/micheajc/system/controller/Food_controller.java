package com.micheajc.system.controller;


import com.micheajc.system.bean.sys_food;
import com.micheajc.system.service.Food_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class Food_controller {

    @Autowired
    Food_service food_service;



    @RequestMapping("/getlistfood")
    @ResponseBody
    public List<sys_food> getfoodclass(){
        return food_service.getlist_food();
    }


    //根据分类名得到食品
    @RequestMapping("/wherefoodclassgetlist")
    @ResponseBody
    public List<sys_food> foodclassgetlist(@RequestBody String json){
        System.out.print(json);
        return food_service.wherefoodclassgetlist(json);
    }
}
