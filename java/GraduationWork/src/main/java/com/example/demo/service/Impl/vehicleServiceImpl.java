package com.example.demo.service.Impl;

import com.example.demo.dao.vehicleMapper;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.vehicleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class vehicleServiceImpl implements vehicleService {
    @Resource
    private vehicleMapper vehicleMapper;

    @Override
    public List<Vehicle> vehicleAll(){
        return vehicleMapper.vehicleAll();
    }

    @Override
    public int addvehicle(Vehicle vehicle){
        return vehicleMapper.addvehicle(vehicle);
    }

    @Override
    public int updatevehicle(Vehicle vehicle){
        return vehicleMapper.updatevehicle(vehicle);
    }

    @Override
    public int deletevehicle(int id){
        return vehicleMapper.deletevehicle(id);
    }
}
