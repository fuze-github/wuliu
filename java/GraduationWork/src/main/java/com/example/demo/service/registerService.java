package com.example.demo.service;

import com.example.demo.entity.Register;

import java.util.List;

public interface registerService {
    //注册用户
    int userregister(Register register);

    //添加token
    Integer addtoken(Register register);

    //修改信息
    Integer updateinformation(Register register);

    //删除信息
    int deleteinformation(int id);

    //查看全部信息
    List<Register> informationAll();

    //查看用户信息
    Register perinformation(int id);

    //修改密码
    int loginupdatepassword(Register register);

    //手机号查询个人信息
    Register phoneperinformation(String phone);
}
