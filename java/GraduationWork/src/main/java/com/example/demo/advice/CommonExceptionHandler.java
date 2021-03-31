package com.example.demo.advice;

import com.example.demo.config.ApiResponse;
import com.example.demo.config.ExtendException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.jws.Oneway;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:全局捕捉异常
 * @author:wu
 */
@RestControllerAdvice(basePackages = {"com.example.demo.controller"})
public class CommonExceptionHandler {

    @ExceptionHandler(ExtendException.class)
    public ApiResponse handleException(ExtendException e){
        ApiResponse response=new ApiResponse();
        response.setCode(e.getCode());
        response.setMsg(e.getMsg());

        return response;
    }

//    @ExceptionHandler(Exception.class)
//    public ApiResponse handleControllerException(Exception e) {
//        ApiResponse response=new ApiResponse();
//        response.setCode(500);
//        response.setMsg(e.getMessage());
//        return response;
//    }

//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Object notFountHandler(HttpServletRequest request,NoHandlerFoundException e){
//        String method = request.getMethod();
//        String path = request.getRequestURI();
//        Map<String,Object> data = new HashMap<>();
//        data.put("method",method);
//        data.put("path",path);
//        return data;
//    }
}
