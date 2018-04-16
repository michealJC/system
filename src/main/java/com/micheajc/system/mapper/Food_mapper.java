package com.micheajc.system.mapper;

import com.micheajc.system.bean.sys_food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Food_mapper {

    //查找全部
    @Select("select * from sys_food")
    public List<sys_food> getlist_food();


    //按分类名查找
    @Select("select * from sys_food where food_foodclass=#{food_foodclass}")
    public List<sys_food> wherefoodclassgetlist(String food_foodclass);

}
