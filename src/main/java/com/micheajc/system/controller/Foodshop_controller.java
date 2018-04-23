package com.micheajc.system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foodshop")
public class Foodshop_controller {

    @RequestMapping("/foodshopmangger")
    public String getshop(){
        return "shopCart";
    }



}
