package com.micheajc.system.mapper;


import com.micheajc.system.bean.SysCarryFood;
import com.micheajc.system.bean.SysMenuTable;
import com.micheajc.system.bean.sys_foodcarryshop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Menumapper {


    //得到桌号的个数
    @Select("SELECT COUNT( *)  FROM  sys_tablenumber")
    public int getzuohao();

    //得到所有桌子是否被选中
    @Select("select renshu,addjine,data,id from sys_tablenumber where zhuangtai=0")
    public List<SysMenuTable> getMenuTable();

    //得到所有相同菜品的菜名和份数
    @Select("SELECT foodname,SUM(foodshuliang) AS foodshuliang  FROM sys_foodcarryshop GROUP BY foodname")
    public List<SysCarryFood> getcarryfood();

    //根据桌号得到所有的菜品
    @Select("SELECT foodname,foodjiage,foodshuliang,foodzuohao  FROM sys_foodcarryshop WHERE foodzuohao=#{foodzuohao}")
    public List<sys_foodcarryshop> getcarryfoodByzuohao(@Param("foodzuohao") String foodzuohao);
}
