package com.example.demo.entity;

import java.util.Date;

public class Register {
    private Integer id; //编号
    private String loginname; //登录用户名
    private String password; //密码
    private String name; //用户名
    private String age; //年龄
    private String sex; //性别
    private String phone; //电话
    private String email; //邮箱
    private String token;//token
    private Date logintime;
    private String time;
    private String judge; //身份
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", logintime=" + logintime +
                ", time='" + time + '\'' +
                ", judge='" + judge + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public Register(Integer id, String loginname, String password, String name, String age, String sex, String phone, String email, String token, Date logintime, String time, String judge, String image) {
        this.id = id;
        this.loginname = loginname;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.token = token;
        this.logintime = logintime;
        this.time = time;
        this.judge = judge;
        this.image = image;
    }

    public Register(){

    }

}
