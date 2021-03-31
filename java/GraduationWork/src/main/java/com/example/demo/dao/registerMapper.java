package com.example.demo.dao;

import com.example.demo.entity.Register;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface registerMapper {
    //注册账户
    @Insert("insert into Register( loginname,password,name,age,sex,phone,email,judge) values (#{loginname},#{password},#{name},#{age},#{sex},#{phone},#{email},#{judge}) ")
    public int userregister(Register register);

    //登录添加token
    @Update("update Register set token=#{token},logintime=#{logintime} where phone=#{phone} ")
    public Integer addtoken(Register register);

    //修改信息
    @Update("update Register set name=#{name},age=#{age},sex=#{sex},phone=#{phone},email=#{email},loginname=#{loginname},image=#{image} where id=#{id} ")
    public Integer updateinformation(Register register);

    //删除信息
    @Delete(" delete from Register where id= #{id} ")
    public int deleteinformation(int id);

    //查询全部信息
    @Select("select * from Register")
    List<Register> informationAll();

    //用户的个人信息
    @Select("select * from Register where id=#{id}")
    Register perinformation(int id);

    //用户的个人信息
    @Select("select * from Register where phone=#{phone}")
    Register phoneperinformation(String phone);

    //修改密码
    @Update("update Register set password=#{password} where phone=#{phone} ")
    public int loginupdatepassword(Register register);

}
