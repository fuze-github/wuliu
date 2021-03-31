package com.example.demo.service.Impl;

import com.example.demo.dao.distributionMapper;
import com.example.demo.entity.Distribution;
import com.example.demo.service.distributionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class distributionServiceImpl implements distributionService {
    @Resource
    private distributionMapper distributionMapper;

    @Override
    public List<Distribution> distribuntionAll(){
        return distributionMapper.distribuntionAll();
    }

    @Override
    public int adddistribuntion(Distribution distribution){
        return distributionMapper.adddistribuntion(distribution);
    }

    @Override
    public int updatedistribuntion(Distribution distribution){
        return distributionMapper.updatedistribuntion(distribution);
    }

    @Override
    public int deletedistribuntion(int id){
        return distributionMapper.deletedistribuntion(id);
    }
}
