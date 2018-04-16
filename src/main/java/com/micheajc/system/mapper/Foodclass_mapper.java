package com.micheajc.system.mapper;


import com.micheajc.system.bean.sys_foodclass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Foodclass_mapper {
    @Select("select * from sys_foodclass")
    public List<sys_foodclass> getfoodclass();
}
