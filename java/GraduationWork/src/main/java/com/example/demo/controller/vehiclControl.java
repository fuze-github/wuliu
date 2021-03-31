package com.example.demo.controller;

import com.example.demo.entity.Vehicle;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/secure")
//车辆
public class vehiclControl {
   @Resource
    private com.example.demo.service.vehicleService vehicleService;

   @RequestMapping("/findvehicle")
    public List<Vehicle> findvehicle(){
       List<Vehicle> vehic = vehicleService.vehicleAll();
       return vehic;
   }

   @RequestMapping("/addvehicle" )
    public String addvehicle(@RequestBody Vehicle vehicle){
       vehicleService.addvehicle(vehicle);
       return "添加成功";
   }

   @RequestMapping("updatevehicle")
    public String updatevehicle(@RequestBody Vehicle vehicle){
        vehicleService.updatevehicle(vehicle);
        return "修改成功";
   }

   @RequestMapping("delevehicle")
    public String delevehicle(int id){
       System.out.print("32323332");
       System.out.print(id);
       vehicleService.deletevehicle(id);
       return "删除成功";
   }
}