package com.example.demo.dao;

import com.example.demo.entity.Vehicle;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface vehicleMapper {
    //查询全部
    @Select("select * from vehicle_information")
    List<Vehicle> vehicleAll();

    //添加车辆信息
    @Insert("insert into vehicle_information(license_plate,remarks) values (#{license_plate},#{remarks})")
    public int addvehicle(Vehicle vehicle);

    //修改车辆信息
    @Update("update vehicle_information set license_plate=#{license_plate},remarks=#{remarks} where id=#{id} ")
    public int updatevehicle(Vehicle vehicle);

    //删除车辆信息
    @Delete(" delete from vehicle_information where id= #{id} ")
    public int deletevehicle(int id);
}
