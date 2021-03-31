package com.example.demo.controller;

import com.example.demo.config.ExtendException;
import com.example.demo.dao.perInformationMapper;
import com.example.demo.dao.registerMapper;
import com.example.demo.entity.Register;
import com.example.demo.service.perInformationService;
import com.example.demo.service.registerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/secure")
public class Information {
    @Resource
    private registerService registerService;
    @Resource
    private perInformationService perInformationService;

    //查询全部用户信息
    @RequestMapping(path = "/findinfomation", method= RequestMethod.POST)
//    @RequestMapping("/findinfomation")
    public List findinfomation(){
        List<Register> vehic = registerService.informationAll();
        for (int i = 0 ; i < vehic.size() ;i++){
            System.out.print(vehic.get(i).getLogintime());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date = sdf.format(vehic.get(i).getLogintime());
            vehic.get(i).setTime(date);
            System.out.print(vehic);
        }
        return vehic;
    }

    //查询个人信息
    @RequestMapping("findpermation")
    public Register findpermation(int id){
        Register list = registerService.perinformation(id);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = sdf.format(list.getLogintime());
        list.setTime(date);
        return list;
    }

    //修改个人信息
    @RequestMapping("/updateformation")
    public String updateformation(@RequestBody Register register){
//        Register temp = new Register();
//        temp.setId(register.getId());
//        temp.setAge(register.getAge());
        registerService.updateinformation(register);
        return "替换成功";
    }

    //删除个人信息
    @RequestMapping("/deleinformation")
    public String deleinformation(int id){
        registerService.deleteinformation(id);
//        perInformationService.deletepassword(login_name);
        return "删除成功";
    }

    //修改密码
    @RequestMapping("uptedapawd")
    public String uptedapawd(@RequestBody Register register){
        String temppassword = register.getPassword();
        String tempphone = register.getPhone();
        int temp = perInformationService.record(tempphone);
        String password =  (String) perInformationService.loginFindAll(tempphone).get("password");
        if (temp == 1){
            if (temppassword.equals(password)){
                registerService.loginupdatepassword(register);
                return "修改成功";
            }else{
                throw new ExtendException(305,"密码错误");
            }
        }else {
            throw new ExtendException(306,"手机号不存在");
        }
    }

    //图片
    @RequestMapping("image")
    public Object image(File file){

        return "";
    }

}
