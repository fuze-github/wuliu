package com.example.demo.controller;

import com.example.demo.config.ExtendException;
import com.example.demo.entity.Register;
import com.example.demo.service.perInformationService;
import com.example.demo.service.registerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class perInformationControl {

    @Resource
    private perInformationService perInformationService;
    @Resource
    private registerService registerService;

    @RequestMapping("/loginp")
    public Register loginp(@RequestBody Register register){
        String password =register.getPassword();
        String phone = register.getPhone();
        String judge = register.getJudge();

        if(perInformationService.record(phone)!=1){
            throw new ExtendException(302,"用户未注册");
        }else{
            String findpassword = (String) perInformationService.loginFindAll(phone).get("password");
            String findjudge = (String) perInformationService.loginFindAll(phone).get("judge");
            if(judge.equals(findjudge)){
                if(password.equals(findpassword)){
                    String jwtToken = Jwts.builder().setSubject(phone).claim("roles", "member").setIssuedAt(new Date())
                            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

                    Date date = new Date();// 获取当前时间
                    Register request = new Register();
                    request.setToken(jwtToken);
                    request.setPhone(phone);
                    request.setLogintime(date);
                    registerService.addtoken(request);

                    Register temp =  registerService.phoneperinformation(phone);
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String date1 = sdf.format(temp.getLogintime());
                    temp.setTime(date1);
                    return temp;
                }else{
                    throw new ExtendException(304,"密码错误");
                }
            }else {
                throw new ExtendException(303,"身份错误");

            }
        }

    }
}
