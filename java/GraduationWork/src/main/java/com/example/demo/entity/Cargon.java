package com.example.demo.entity;

import java.util.Date;

public class Cargon {
    private int id;
    private String goodsname;
    private String weight;
    private String address;
    private String Range;
    private String name;
    private String uesrstate;
    private String adminstate;
    private Date time;
    private String vehicle;
    private String driver;
    private String goodsstate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRange() {
        return Range;
    }

    public void setRange(String range) {
        Range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUesrstate() {
        return uesrstate;
    }

    public void setUesrstate(String uesrstate) {
        this.uesrstate = uesrstate;
    }

    public String getAdminstate() {
        return adminstate;
    }

    public void setAdminstate(String adminstate) {
        this.adminstate = adminstate;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getGoodsstate() {
        return goodsstate;
    }

    public void setGoodsstate(String goodsstate) {
        this.goodsstate = goodsstate;
    }

    @Override
    public String toString() {
        return "Cargon{" +
                "id=" + id +
                ", goodsname='" + goodsname + '\'' +
                ", weight='" + weight + '\'' +
                ", address='" + address + '\'' +
                ", Range='" + Range + '\'' +
                ", name='" + name + '\'' +
                ", uesrstate='" + uesrstate + '\'' +
                ", adminstate='" + adminstate + '\'' +
                ", time=" + time +
                ", vehicle='" + vehicle + '\'' +
                ", driver='" + driver + '\'' +
                ", goodsstate='" + goodsstate + '\'' +
                '}';
    }

    public Cargon(int id, String goodsname, String weight, String address, String range, String name, String uesrstate, String adminstate, Date time, String vehicle, String driver, String goodsstate) {
        this.id = id;
        this.goodsname = goodsname;
        this.weight = weight;
        this.address = address;
        Range = range;
        this.name = name;
        this.uesrstate = uesrstate;
        this.adminstate = adminstate;
        this.time = time;
        this.vehicle = vehicle;
        this.driver = driver;
        this.goodsstate = goodsstate;
    }

    public Cargon() {

    }
}
