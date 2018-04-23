package com.micheajc.system.controller;


import com.micheajc.system.bean.sys_foodshop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/foodshop")
public class Foodshop_controller {

    private static List<sys_foodshop> foodshops=null;
    @RequestMapping("/foodshopmangger")
    @ResponseBody
    public String foodshopmangger(@RequestBody  List<sys_foodshop> shopdata){
        foodshops=shopdata;
        return "1";
    }



    @RequestMapping("/foodshopmangger2")
    public ModelAndView foodshopmangger2(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("shopCart");
        modelAndView.addObject("shopdata",foodshops);
        return modelAndView;
    }


}
