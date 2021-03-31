package com.example.demo.entity;

public class Distribution {
    private int id;
    private String name;
    private String describe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
    public Distribution(int id, String name, String describe) {
        this.id = id;
        this.name = name;
        this.describe = describe;
    }

    public Distribution() {

    }
}
