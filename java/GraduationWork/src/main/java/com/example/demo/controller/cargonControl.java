package com.example.demo.controller;

import com.example.demo.entity.Cargon;
import com.example.demo.service.cargonService;
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
@RequestMapping("/secure")
public class cargonControl {
    @Resource
    private cargonService cargonService;
   //用户添加货物
    @RequestMapping("/addcargon")
    public String addcargon(@RequestBody Cargon cargon){
        cargon.setUesrstate("1");
        Date currentTime = new Date();
        cargon.setTime(currentTime);
        cargonService.addcargon(cargon);
        return "添加成功";
    }
    //管理员查看全部数据
    @RequestMapping("/findcargon")
    public List<Cargon> findcargon(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Cargon> carg = cargonService.cargonAll();
        return carg;
    }

    //用户查看自己的货物信息
    @RequestMapping("/usercargonAll")
    public List<Cargon> usercargonAll(String name){
        List<Cargon> carg = cargonService.usercargonAll(name);
        return carg;
    }

    //管理员同意或者拒绝货物
    @RequestMapping("/userjudey")
    public String usercargon(@RequestBody Cargon cargon){
        String judy = cargon.getAdminstate();
        if(judy.equals("1")){
            cargon.setGoodsstate("1");
            cargon.setUesrstate("1");
            cargonService.usercargon(cargon);
            return "success";
        }else {
            Cargon failcar = new Cargon();
            failcar.setUesrstate("3");
            failcar.setAdminstate("2");
            failcar.setGoodsname(cargon.getGoodsname());
            cargonService.usercargonn(failcar);
            return "fail";
        }

    }
    //管理员确认送达
    @RequestMapping("adminservi")
    public String adminservice(@RequestBody Cargon cargon){
        cargonService.adminservi(cargon);
        List<Cargon> result = cargonService.cargonAll();
        Cargon temp = new Cargon();
        for(int a = 0 ; a<result.size() ; a++){
            if(result.get(a).getUesrstate().equals("2")&&result.get(a).getAdminstate().equals("3")){
                temp.setGoodsname(result.get(a).getGoodsname());
                temp.setGoodsstate("2");
                cargonService.goodsservi(temp);
            }
        }
        return "success";
    }
    //用户确认送达
    @RequestMapping("userservi")
    public String userservi(@RequestBody Cargon cargon){
        cargonService.userservi(cargon);
        List<Cargon> result = cargonService.cargonAll();
        Cargon temp = new Cargon();
        for(int a = 0 ; a<result.size() ; a++){
            if(result.get(a).getUesrstate().equals("2")&&result.get(a).getAdminstate().equals("3")){
                temp.setGoodsname(result.get(a).getGoodsname());
                temp.setGoodsstate("2");
                cargonService.goodsservi(temp);
            }
        }
        return "success";
    }

    //管理员同意发货
    @RequestMapping("/adminagree")
    public List<Cargon> adminagree(){
        List<Cargon> temp = cargonService.adminagree("1");
        return temp;
    }

    //用户查看运输中的货物
    @RequestMapping("/usertransport")
    public List<Cargon> usertransport(Cargon cargon){
        List<Cargon> temp = cargonService.usertransport(cargon);
        return temp;
    }

    //双方确定
    @RequestMapping("/twoagree")
    public List<Cargon> twoagree(){
        List<Cargon> temp = cargonService.bothagree("3","2");
        return temp;
    }

    //用户查看双方确定的货物
    @RequestMapping("/userarrive")
    public List<Cargon> userarrive(Cargon cargon){
        List<Cargon> temp = cargonService.userarrive(cargon);
        return temp;
    }

}
