package com.micheajc.system.controller;


import com.micheajc.system.bean.sys_foodcarryshop;
import com.micheajc.system.bean.sys_foodshop;
import com.micheajc.system.service.Foodcarryshop_service;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/foodshop")
public class Foodshop_controller {

    private static List<sys_foodshop> foodshops=null;


    @RequestMapping("/foodshopmangger")
    @ResponseBody
    public String foodshopmangger(@RequestBody  List<sys_foodshop> shopdata){
        foodshops=shopdata;
        for(int i=0;i<foodshops.size();i++){
            String jiage=foodshops.get(i).getFoodjiage().replace("$","");
            String shuliang=foodshops.get(i).getFoodshuliang();
            System.out.print(jiage+shuliang);
            foodshops.get(i).setFoodjiage((Integer.valueOf(shuliang)*Integer.valueOf(jiage))+"");
        }

        return "1";
    }



    @RequestMapping("/foodshopmangger2")
    public ModelAndView foodshopmangger2(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("shopCart");
        modelAndView.addObject("shopdata",foodshops);
        return modelAndView;
    }

    @Autowired
    private Foodcarryshop_service foodcarryshop_service;
    @RequestMapping(value = "/foodcarryshop",method = RequestMethod.POST)
    @ResponseBody
    public String foodcarryshop(@RequestBody String jsondata){
        //判断传来的参数中座号是否被占用
        JSONArray jsonArray=new JSONArray(jsondata);
        JSONObject foodzuohao=jsonArray.getJSONObject(0);
        int id=foodzuohao.getInt("foodzuohao");
        int foodtablezhuangtai=foodcarryshop_service.gettablezhuangtaibyid(id);
        if(foodtablezhuangtai==1){
            //如果桌号为空就为他插入
            List<sys_foodcarryshop> foodcarryshops=new ArrayList<sys_foodcarryshop>();
            JSONObject jsonfood=jsonArray.getJSONObject(1);
            JSONArray jsonArray1=jsonfood.getJSONArray("food");
            for (int i=0;i<jsonArray1.length();i++){
                JSONObject food1=jsonArray1.getJSONObject(i);
                foodcarryshops.add(new sys_foodcarryshop(food1.getString("foodname"),food1.getString("foodjiage"),food1.getString("foodshuliang"),String.valueOf(food1.getInt("foodzuohao"))));
            }
            int ll=foodcarryshop_service.insertfoodcarryshop(foodcarryshops);
            if(ll==1){
                //添加成功后把桌子的状态设为0,和把人数，金额输入进去
                Date date=new Date();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                foodcarryshop_service.updatetablenumber(0,jsonArray.getJSONObject(2).getInt("renshu"),jsonArray.getJSONObject(3).getInt("addjine"),id,simpleDateFormat.format(date).toString());
                return "1";
            }
        }else {
            return "0";
        }
        return "0";
    }


}
