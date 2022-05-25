package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {
    //使用ServletAPI向request域共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope","hello servlet api");
        return "success";
    }

    @RequestMapping("/testModeAndView")
    public ModelAndView testModeAndView(){
        ModelAndView mview=new ModelAndView();
        //处理模型数据,即向请求与request共享数据
        mview.addObject("testRequestScope","hello,ModeAndView");
        //设置视图名称
        mview.setViewName("success");
        return mview;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testRequestScope","hello,map");
        return "success";
    }


    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
    modelMap.addAttribute("testRequestScope","hello,modelMap");

    return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSession","hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope","hello,application");
        return "success";
    }



}
