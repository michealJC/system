package com.micheajc.system.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Loginmapper {

    @Select("select userpassword from loginuser where username=#{username}")
    public String getpasswordbyusername(@Param("username") String username);
}
