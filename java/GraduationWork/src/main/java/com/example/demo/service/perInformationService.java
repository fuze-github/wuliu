package com.example.demo.service;

import com.example.demo.entity.Login;

import java.util.Map;

public interface perInformationService {
    //查询全部
    Map loginFindAll(String phone);
    //查看登录表里面有没有该账户
    Integer record(String username);
    //新增数据
    int addnew(Login login);
    //修改密码
    int updatepassword(Login login);
    //删除账户
    int deletepassword(String username);
}
