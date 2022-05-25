package com.mlf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/ok")
    public String getOk(){
        return "ok";
    }



}
