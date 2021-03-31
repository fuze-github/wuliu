package com.example.demo.entity;

public class Login {
    private Integer id; //编号
    private String username; //用户名
    private String password; //密码
    private String judge; //身份判断

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public Login(Integer id, String username, String password, String judge) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.judge = judge;
    }

    public Login() {
    }
}
