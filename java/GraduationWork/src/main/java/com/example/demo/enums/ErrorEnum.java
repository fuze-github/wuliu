package com.example.demo.enums;

public enum ErrorEnum {


    CASH_WX_ERROR(500003,"系统繁忙,请稍后再试"),

    SYSTEM_ERROR(999999,"系统异常"),
    PICTURE_UPLOAD_ERROR(900001,"图片上传失败"),
    PARAM_ERROR(900002,"参数错误"),
    PARAM_EMPTY(900002,"参数为空"),
    DELETE_FAIL(900003,"删除失败");



    private int code;
    private String message;

    ErrorEnum(int code, String message){
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return message;
    }


}
