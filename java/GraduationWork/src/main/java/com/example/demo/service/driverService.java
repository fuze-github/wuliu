package com.example.demo.service;

import com.example.demo.entity.Driver;

import java.util.List;

public interface driverService {
    //查询全部司机信息
    List<Driver> derverAll();

    //添加司机信息
    int addderver(Driver driver);

    //修改司机信息
    int updatederver(Driver driver);

    //删除司机信息
    int deletederver(int id);
}
