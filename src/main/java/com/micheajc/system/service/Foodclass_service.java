package com.micheajc.system.service;


import com.micheajc.system.bean.sys_foodclass;
import com.micheajc.system.mapper.Foodclass_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Foodclass_service {

    @Autowired
    public Foodclass_mapper foodclass_mapper;

    public List<sys_foodclass> getfoodclass(){

        return foodclass_mapper.getfoodclass();
    }
}
