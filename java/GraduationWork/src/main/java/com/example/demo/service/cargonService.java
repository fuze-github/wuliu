package com.example.demo.service;

import com.example.demo.entity.Cargon;

import java.util.List;

public interface cargonService {
    //添加货物信息
    int addcargon(Cargon cargon);

    //查看客户货物信息
    List<Cargon> cargonAll();

    //用户查看自己的货物信息
    List<Cargon> usercargonAll(String name);

    //管理员审核同意货物信息
    int usercargon(Cargon cargon);

    //管理员审核拒绝货物
    int usercargonn(Cargon cargon);

    //管理员确认送达
    int adminservi(Cargon cargon);

    //用户确认送达
    int userservi(Cargon cargon);

    //货物状态送达
    int goodsservi(Cargon cargon);

    //管理员确定发货货物
    List<Cargon> adminagree(String adminstate);

    //用户查看货物运输中
    List<Cargon> usertransport(Cargon cargon);

    //双方确定
    List<Cargon> bothagree(String adminstate,String uesrstate);

    //用户查看双方确定货物
    List<Cargon> userarrive(Cargon cargon);
}
