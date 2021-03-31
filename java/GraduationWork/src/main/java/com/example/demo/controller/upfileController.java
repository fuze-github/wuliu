package com.example.demo.controller;


import com.example.demo.config.Upload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@CrossOrigin
@RestController
//@RequestMapping("/secure")
public class upfileController {
    @RequestMapping(value = "/upload2")//测试的url接口
    public String upLoadFile(@RequestParam(value = "file",required = true)MultipartFile img, HttpServletRequest request){
        String imagPath = "images";
        String sqlpath = Upload.uploadFile(request,img,imagPath,"images");
        System.out.print(sqlpath);
        return "";
    }

}
