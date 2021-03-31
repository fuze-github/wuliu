package com.example.demo.entity;

public class Vehicle {
    private int id;
    private String license_plate;
    private String remarks;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", license_plate='" + license_plate + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
