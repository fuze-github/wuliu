package com.example.demo.controller;

import com.example.demo.entity.Distribution;
import com.example.demo.service.distributionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/secure")
public class distributionControl {
    @Resource
    private distributionService distributionService;

    @RequestMapping("/finddistribution")
    public List<Distribution> finddistribution(){
        List<Distribution> vehic = distributionService.distribuntionAll();
        return vehic;
    }

    @RequestMapping("/adddistribution" )
    public String adddistribution(@RequestBody Distribution distribution){
        distributionService.adddistribuntion(distribution);
        return "添加成功";
    }

    @RequestMapping("updatedistribution")
    public String updatedistribution(@RequestBody Distribution distribution){
        distributionService.updatedistribuntion(distribution);
        return "修改成功";
    }

    @RequestMapping("delevedistribution")
    public String delevedistribution(int id){
        System.out.print("32323332");
        System.out.print(id);
        distributionService.deletedistribuntion(id);
        return "删除成功";
    }
}
