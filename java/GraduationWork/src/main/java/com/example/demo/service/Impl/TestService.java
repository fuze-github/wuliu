package com.example.demo.service.Impl;

import com.example.demo.config.ExtendException;
import com.example.demo.entity.User;
import com.example.demo.enums.ErrorEnum;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public User test(Integer id){
        if (id==1){
            throw new ExtendException(ErrorEnum.CASH_WX_ERROR);
        }
        User user=new User();
        user.setId(1);
        user.setUsername("张三");
        return user;
    }
}
