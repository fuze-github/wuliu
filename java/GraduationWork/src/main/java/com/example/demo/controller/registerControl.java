package com.example.demo.controller;

import com.example.demo.config.ExtendException;
import com.example.demo.entity.Register;
import com.example.demo.entity.Login;
import com.example.demo.enums.ErrorEnum;
import com.example.demo.service.perInformationService;
import com.example.demo.service.registerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@CrossOrigin
@RestController
public class registerControl {
    @Resource
    private registerService registerService;
    @Resource
    private perInformationService perInformationService;

    private Login login;

    @RequestMapping("/add" )
    public String userRegister( @RequestBody Register register){
        String phone = register.getPhone();
        int number = perInformationService.record(phone);
        if(number == 0){
            register.setJudge("2");
            registerService.userregister(register);
            return "注册成功";
        }else {
            throw new ExtendException(301,"手机号已被注册");
        }

//        Login newlogin = new Login();
//        newlogin.setUsername(register.getLoginname());
//        newlogin.setPassword(register.getPassword());
//        newlogin.setJudge("2");
//        perInformationService.addnew(newlogin);
//        System.out.print(registerService.userregister(Register));

    }
}
