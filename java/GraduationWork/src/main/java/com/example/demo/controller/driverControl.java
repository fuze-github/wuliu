package com.example.demo.controller;

import com.example.demo.entity.Driver;
import com.example.demo.service.driverService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/secure")
public class driverControl {
   @Resource
    private driverService driverService;

    @RequestMapping("/finddriver")
    public List<Driver> finddriver(){
        List<Driver> vehic = driverService.derverAll();
        return vehic;
    }

    @RequestMapping("/adddriver" )
    public String adddriver(@RequestBody Driver driver){
        driverService.addderver(driver);
        return "添加成功";
    }

    @RequestMapping("updatedriver")
    public String updatedriver(@RequestBody Driver driver){
        driverService.updatederver(driver);
        return "修改成功";
    }

    @RequestMapping("delevedriver")
    public String delevedriver(int id){
        System.out.print("32323332");
        System.out.print(id);
        driverService.deletederver(id);
        return "删除成功";
    }
}
