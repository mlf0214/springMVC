package com.test.mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping(value = "/test")
    public String target2(){
        return "target";
    }

}
