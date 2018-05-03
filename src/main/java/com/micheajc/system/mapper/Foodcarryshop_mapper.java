package com.micheajc.system.mapper;


import org.apache.ibatis.annotations.*;

@Mapper
public interface Foodcarryshop_mapper {

    @Insert("INSERT INTO sys_foodcarryshop VALUES (#{foodname},#{foodjiage},#{foodshuliang},#{foodzuohao})")
    public int insertfoodcarryshop(@Param("foodname") String foodname,@Param("foodjiage") String foodjiage,@Param("foodshuliang") String foodshuliang,@Param("foodzuohao") String foodzuohao);


    @Select("SELECT zhuangtai FROM sys_Tablenumber WHERE id=#{id}")
    public int gettablezhuangtaibyid(int id);

    //改变桌号的状态
    @Update("UPDATE sys_Tablenumber SET zhuangtai = #{zhuangtai} WHERE id = #{id}")
    public void updatezhuangtai(@Param("zhuangtai") int zhuangtai,@Param("id") int id);

    //改变桌号中的信息
    @Update("UPDATE sys_Tablenumber SET renshu=#{renshu},addjine=#{addjine},zhuangtai = #{zhuangtai} WHERE id = #{id};")
    public void updatetablenumber(@Param("zhuangtai") int zhuangtai,@Param("renshu") int renshu,@Param("addjine") int addjine,@Param("id") int id);
}
