package com.example.demo.config;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 *
 * author:wu
 * date:2020-7-18
 * time:20:49
 *
 * */
public class Upload {
    /**
     * 获取绝对路径      request.getServletContext().getRealPath()
     * 获取相对路径      request.getContextPath()  项目名
     * 获取http        request.getScheme()
     * 获取主机名       request.getServerName()
     * 获取端口号       request.getServerPort()
     * */
    public static String uploadFile(HttpServletRequest request, @RequestParam MultipartFile file, String folderName,String type){

        //文件上传的保存路径
//        String path=request.getServletContext().getRealPath(File.separator+folderName);
        String path="E:/project/GraduationWork/src/main/resources/images";
        System.out.println("上传路径："+path);
        //创建File对象，向该路径保存文件
        File saveFile=new File(path);

        //如果保存路径不存在，则创建该文件夹
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }

        //获取上传文件的名称
        String fileName=file.getOriginalFilename();

        //获取上传文件的后缀名
        String suffix=fileName.substring(fileName.lastIndexOf("."));

        //创建一个新的随机名字
        String newName= UUID.randomUUID().toString();

        //文件的新名字
        String newFileName=newName+suffix;

        if (type.equals("images")){
            fileName=newFileName;
        }
        //保存文件
        try {
            file.transferTo(new File(saveFile,fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回保存到数据库的的文件路径
        String dbPath="/Blog"+"/"+folderName+"/"+fileName;
//        String dbPath=request.getContextPath()+"/"+folderName+"/"+fileName;
        return dbPath;
    }
}
