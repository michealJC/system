package com.micheajc.system.service;


import com.micheajc.system.bean.sys_foodspecial;
import com.micheajc.system.mapper.Foodspecial_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableAutoConfiguration
public class Foodspecial_service {

    @Autowired
    private Foodspecial_mapper foodspecial_mapper;

    public List<sys_foodspecial> getfoodspeciallist(){
        return foodspecial_mapper.getfoodspeciallist();
    }
}
