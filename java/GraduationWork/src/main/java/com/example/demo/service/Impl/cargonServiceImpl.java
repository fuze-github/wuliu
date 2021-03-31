package com.example.demo.service.Impl;

import com.example.demo.dao.cargonMapper;
import com.example.demo.entity.Cargon;
import com.example.demo.service.cargonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class cargonServiceImpl implements cargonService {
    @Resource
    private cargonMapper cargonMapper;

    @Override
    public int addcargon(Cargon cargon){
        return cargonMapper.addcargon(cargon);
    }

    @Override
    public List<Cargon> cargonAll(){
        return cargonMapper.cargonAll();
    }

    @Override
    public List<Cargon> usercargonAll(String name){
        return cargonMapper.usercargonAll(name);
    }

    @Override
    public int usercargon(Cargon cargon){
        return cargonMapper.usercargon(cargon);
    }

    @Override
    public int usercargonn(Cargon cargon){
        return cargonMapper.usercargonn(cargon);
    }

    @Override
    public int adminservi(Cargon cargon){
        return cargonMapper.adminservi(cargon);
    }

    @Override
    public int userservi(Cargon cargon){
        return cargonMapper.userservi(cargon);
    }

    @Override
    public int goodsservi(Cargon cargon){
        return cargonMapper.goodsservi(cargon);
    }

    @Override
    public List<Cargon> adminagree(String adminstate){
        return cargonMapper.adminagree(adminstate);
    }

    @Override
    public List<Cargon> usertransport(Cargon cargon){
        return cargonMapper.usertransport(cargon);
    }

    @Override
    public List<Cargon> bothagree(String adminstate,String uesrstate){
        return cargonMapper.bothagree(adminstate,uesrstate);
    }

    @Override
    public List<Cargon> userarrive(Cargon cargon){
        return cargonMapper.userarrive(cargon);
    }
}
