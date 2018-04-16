package com.micheajc.system.service;


import com.micheajc.system.bean.sys_food;
import com.micheajc.system.mapper.Food_mapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Food_service {

    @Autowired
    private Food_mapper food_mapper;

    public List<sys_food> getlist_food(){

        return food_mapper.getlist_food();
    }

    public List<sys_food> wherefoodclassgetlist(String json){
        JSONObject jsonObject=new JSONObject(json);
        String food_foodclass=jsonObject.get("food_foodclass").toString();
        return food_mapper.wherefoodclassgetlist(food_foodclass);
    }
}
