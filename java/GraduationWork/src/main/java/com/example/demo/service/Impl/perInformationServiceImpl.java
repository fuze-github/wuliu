package com.example.demo.service.Impl;

import com.example.demo.dao.perInformationMapper;
import com.example.demo.entity.Login;
import com.example.demo.service.perInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class perInformationServiceImpl implements perInformationService {
    @Resource
    private perInformationMapper perInformationMapper;

    @Override
    public Map loginFindAll(String phone) {
        return perInformationMapper.loginFindAll(phone);
    }

    @Override
    public Integer record(String username){
        return perInformationMapper.record(username);
    }

    @Override
    public int addnew(Login login) {
        return perInformationMapper.addnew(login);
    }

    @Override
    public int updatepassword(Login login){
        return perInformationMapper.updatepassword(login);
    }

    @Override
    public  int deletepassword(String username){
        return perInformationMapper.deletepassword(username);
    }
}
