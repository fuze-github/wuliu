package com.example.demo.dao;



import com.example.demo.entity.Driver;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface driverMapper {
    //查询全部
    @Select("select * from driver_information")
    List<Driver> derverAll();

    //添加车辆信息
    @Insert("insert into driver_information(name,remarks,phone,address) values (#{name},#{remarks},#{phone},#{address})")
    public int addderver(Driver driver);

    //修改车辆信息
    @Update("update driver_information set name=#{name},remarks=#{remarks},phone=#{phone},address=#{address} where id=#{id} ")
    public int updatederver(Driver driver);

    //删除车辆信息
    @Delete(" delete from driver_information where id= #{id} ")
    public int deletederver(int id);
}
