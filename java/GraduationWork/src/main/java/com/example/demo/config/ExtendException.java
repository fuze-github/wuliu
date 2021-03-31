package com.example.demo.config;


import com.example.demo.enums.ErrorEnum;

public class ExtendException extends  RuntimeException {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return message;
    }

    public ExtendException(ErrorEnum errorEnum) {
        this(errorEnum.getCode(),errorEnum.getMsg());
    }

    public ExtendException(int code, String message) {
        super("");
        this.code = code;
        this.message = message;
    }
}