package com.micheajc.system.service;

import com.micheajc.system.bean.sys_foodcarryshop;
import com.micheajc.system.mapper.Foodcarryshop_mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Foodcarryshop_service {

    @Autowired
    private Foodcarryshop_mapper foodcarryshop_mapper;


    public int insertfoodcarryshop(List<sys_foodcarryshop> foodcarryshop){
           for (int i=0;i<foodcarryshop.size();i++){
               foodcarryshop_mapper.insertfoodcarryshop(foodcarryshop.get(i).getFoodname(),foodcarryshop.get(i).getFoodjiage(),foodcarryshop.get(i).getFoodshuliang(),foodcarryshop.get(i).getFoodzuohao());

           }
           return 1;
    }

    public int gettablezhuangtaibyid(int id){
        return foodcarryshop_mapper.gettablezhuangtaibyid(id);
    }

    public void updatezhuangtai(int zhuangtai,int id){
        foodcarryshop_mapper.updatezhuangtai(zhuangtai, id);
    }


    public void updatetablenumber(int zhuangtai,int renshu,int addjine,int id,String data){
        foodcarryshop_mapper.updatetablenumber(zhuangtai,renshu, addjine, id,data);
    }
}
