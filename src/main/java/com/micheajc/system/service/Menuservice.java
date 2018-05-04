package com.micheajc.system.service;


import com.micheajc.system.bean.SysMenuTable;
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
}
