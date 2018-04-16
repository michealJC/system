package com.micheajc.system.mapper;

import com.micheajc.system.bean.sys_foodspecial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Foodspecial_mapper {
    @Select("select * from sys_foodspecial")
    public List<sys_foodspecial> getfoodspeciallist();
}
