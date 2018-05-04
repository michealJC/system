package com.micheajc.system.controller;

import com.micheajc.system.bean.SysCarryFood;
import com.micheajc.system.bean.SysMenuTable;
import com.micheajc.system.bean.sys_foodcarryshop;
import com.micheajc.system.service.Menuservice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Menu")
public class MenuController {


    @Autowired
    private Menuservice menuservice;


    @RequestMapping("/getzuohao")
    @ResponseBody
    public int getzuohao(){
        return menuservice.getzuohao();
    }

    //得到所有座号为选中的桌子状态
    @RequestMapping(value = "/getMenuTable",method = RequestMethod.POST)
    @ResponseBody
    public List<SysMenuTable> getMenuTable(){
        return menuservice.getMenutable();
    }
    //得到所有相同菜品的菜名和份数
    @RequestMapping(value = "/getcarryfood",method = RequestMethod.POST)
    @ResponseBody
    public List<SysCarryFood> getcarryfood(){
        return menuservice.getcarryfood();
    }

    //根据桌号得到所有的菜品
    @RequestMapping(value = "/getcarryfoodByzuohao",method = RequestMethod.POST)
    @ResponseBody
    public List<sys_foodcarryshop> getcarryfoodByzuohao(@RequestBody String foodzhuohao){
        JSONObject jsonObject=new JSONObject(foodzhuohao);
        return menuservice.getcarryfoodByzuohao(jsonObject.getString("foodzuohao"));
    }


    //清空所有的桌号
    @RequestMapping(value = "updateTable",method = RequestMethod.POST)
    @ResponseBody
    public String delectTable(@RequestBody String data){
            try {
                JSONObject jsonObject=new JSONObject(data);
                String id=jsonObject.getString("id");
                //清空之前把订单转到历史订单中

                menuservice.updatetable(id);
                //根据菜品清空
                menuservice.delectfoodByzuohao(id);
                return "1";
            }catch (Exception e){
                return "0";
            }
    }
}
