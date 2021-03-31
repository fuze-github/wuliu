package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
        * 数据访问层
        */
@Mapper
public interface UserMapper {
    //查询全部
    @Select("select * from Login")
    List<User> findAll();

    //新增数据
    @Insert(" insert into  Login( username,password ) values (#{username},#{password}) ")
    public int save(User user);

    //删除数据
    @Delete(" delete from Login where id= #{id} ")
    public int delete(int id);

    //根据id查找
    @Select("select * from Login where id= #{id} ")
    public User get(int id);

    //更新数据
    @Update("update Login set username=#{username},password=#{password} where id=#{id} ")
    public int update(User user);
}
