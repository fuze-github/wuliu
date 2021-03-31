package com.example.demo.service.Impl;

import com.example.demo.dao.driverMapper;
import com.example.demo.entity.Driver;
import com.example.demo.service.driverService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class driverServiceImpl implements driverService {
    @Resource
    private driverMapper driverMapper;

    @Override
    public List<Driver> derverAll(){
        return driverMapper.derverAll();
    }

    @Override
    public int addderver(Driver driver){
        return driverMapper.addderver(driver);
    }

    @Override
    public int updatederver(Driver driver){
        return driverMapper.updatederver(driver);
    }

    @Override
    public int deletederver(int id){
        return driverMapper.deletederver(id);
    }
}
