package com.test.controller;

import com.test.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    //"/"-->/web-inf/templates/index.html
    @RequestMapping(value = "/")
    public String index(){
        //返回视图名称
        return "index";
    }
    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }
    @RequestMapping("/a*a/test")
    public String TargetTest(){
        return "target";
    }

    @RequestMapping("/test/{name}")
    public String getName(@PathVariable("name")String name
    ){
            System.out.println("名字"+name);
        return "target";
    }
    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "target";
    }
}
