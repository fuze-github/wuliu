package com.example.demo.service;

import com.example.demo.entity.Vehicle;

import java.util.List;

public interface vehicleService {
    //查询全部车辆信息
    List<Vehicle> vehicleAll();

    //添加车辆信息
    int addvehicle(Vehicle vehicle);

    //修改车辆信息
    int updatevehicle(Vehicle vehicle);

    //删除车辆信息
    int deletevehicle(int id);
}
