package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 控制层，导入service层
 */
@CrossOrigin
@Controller
public class UserControl {
    @Resource
    private UserService userService;

    //查询全部
    @RequestMapping("/list")
    public String userList(Model model){
        List<User> users = userService.findAll();
//        for(User str : users) {
//            System.out.println(str.getId());
//        }
        model.addAttribute("users",users);
        return "index";
    }

    //新增数据
    @RequestMapping("/addd")
    public String save(User user){
        userService.save(user);
        System.out.print(userService.save(user));
        return "redirect:/list";
    }
    @RequestMapping("/useradd")
    public String add(){
        return "add";
    }

    //删除数据
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, HttpServletResponse servletResponse) throws IOException {
        int count =userService.delete(id);
        if(count==1){
            servletResponse.sendRedirect("/list");
        }
        return "error";
    }

    //根据id查找
    @GetMapping("/updatePage/{id}")
    public String updatePage(Model model,@PathVariable int id){
        User users = userService.get(id);
        model.addAttribute("users",users);
        return "modifi";
    }

    //更新数据
    @PostMapping("/update")
    public String updateUser(Model model, User user, HttpServletRequest request){
        String id = request.getParameter("id");
        User userById = userService.get(Integer.parseInt(id));
        userService.update(user);
        System.out.println(user);
        return "redirect:/list";
    }

}