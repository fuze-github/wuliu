package com.example.demo.service;

import com.example.demo.entity.Distribution;

import java.util.List;

public interface distributionService {
    //查询全部
    List<Distribution> distribuntionAll();
    //新增范围
    int adddistribuntion(Distribution distribution);
    //修改范围
    int updatedistribuntion(Distribution distribution);
    //删除范围
    int deletedistribuntion(int id);
}
