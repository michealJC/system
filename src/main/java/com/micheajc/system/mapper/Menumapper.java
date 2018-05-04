package com.micheajc.system.mapper;


import com.micheajc.system.bean.SysCarryFood;
import com.micheajc.system.bean.SysMenuTable;
import com.micheajc.system.bean.sys_foodcarryshop;
import org.apache.ibatis.annotations.*;

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

    //清空桌子信息
    @Update("UPDATE sys_tablenumber SET zhuangtai=1,renshu=0,addjine=0,DATA='0' WHERE id=#{id}")
    public void updetetable(@Param("id")String id);
    //根据桌号清空菜品
    @Delete("DELETE FROM sys_foodcarryshop WHERE foodzuohao=#{foodzuohao}")
    public void delectfoodByzuohao(@Param("foodzuohao") String foodzuohao);

    //清空之前把桌子的历史信息保存到历史记录表中
}
