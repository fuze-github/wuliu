package com.example.demo.service.Impl;

import com.example.demo.dao.registerMapper;
import com.example.demo.entity.Register;
import com.example.demo.service.registerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class registerServiceImpl implements registerService {
    @Resource
    private registerMapper registerMapper;

    @Override
    public int userregister(Register register) {
        return registerMapper.userregister(register);
    }

    @Override
    public Integer addtoken(Register register) {
        return registerMapper.addtoken(register);
    }

    @Override
    public Integer updateinformation(Register register){
        return registerMapper.updateinformation(register);
    }

    @Override
    public int deleteinformation(int id){
        return registerMapper.deleteinformation(id);
    }

    @Override
    public List<Register> informationAll(){
        return registerMapper.informationAll();
    }

    @Override
    public Register perinformation(int id){
        return registerMapper.perinformation(id);
    }

    @Override
    public int loginupdatepassword(Register register){
        return registerMapper.loginupdatepassword(register);
    }

    @Override
    public Register phoneperinformation(String phone){
        return registerMapper.phoneperinformation(phone);
    }
}
