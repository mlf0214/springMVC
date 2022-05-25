package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    /*使用RESTFul模拟用户资源的增删改查
    /users  get  查询用户所有信息
    /user/1  get  查询用户id查询用户信息
    /user  post  查询用户所有信息
    /user/1  delete  删除用户信息
    /user  put  修改用户信息
    */

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUsers(){
        System.out.println("查询所有用户信息");

        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable Integer id){
        System.out.println("根据用户id查询信息");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(String username,String password){
        System.out.println("添加用户信息:"+username+";"+password);

        return "success";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(String username,String password){
        System.out.println("修改:"+username+";"+password);
        return "success";
    }
}
