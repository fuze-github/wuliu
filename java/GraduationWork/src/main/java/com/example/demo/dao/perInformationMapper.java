package com.example.demo.dao;

import com.example.demo.entity.Login;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface perInformationMapper {
    //查询该账户对应密码
    @Select("select password,judge from Register where phone= #{phone}")
    public Map loginFindAll(String phone);

    //查看登录表里面有没有该账户
    @Select("SELECT COUNT(*) FROM Register where phone= #{phone}")
    public Integer record(String phone);

    //添加注册账户和密码
    @Insert(" insert into Login( username,password,judge ) values (#{username},#{password},#{judge}) ")
    public int addnew(Login login);

    //修改密码
    @Update("update Login set password=#{password} where username=#{username} ")
    public int updatepassword(Login login);

    //删除账户
    @Delete(" delete from Login where username= #{username} ")
    public int deletepassword(String username);
}
