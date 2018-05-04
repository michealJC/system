package com.micheajc.system.controller;

import com.micheajc.system.bean.SysMenuTable;
import com.micheajc.system.service.Menuservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
