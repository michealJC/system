package com.micheajc.system.service;


import com.micheajc.system.bean.SysCarryFood;
import com.micheajc.system.bean.SysMenuTable;
import com.micheajc.system.bean.sys_foodcarryshop;
import com.micheajc.system.mapper.Menumapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Menuservice {

    @Autowired
    private Menumapper menumapper;

    public int getzuohao(){
        return menumapper.getzuohao();
    }

    public List<SysMenuTable> getMenutable(){
        return menumapper.getMenuTable();
    }

    //得到所有相同菜品的菜名和份数
    public List<SysCarryFood> getcarryfood(){
        return menumapper.getcarryfood();
    }
    //根据桌号得到所有的菜品
    public List<sys_foodcarryshop> getcarryfoodByzuohao(String foodzuohao){
       return menumapper.getcarryfoodByzuohao(foodzuohao);
    }
}
