package com.test.rest.controller;
import com.test.rest.bean.Employee;
import com.test.rest.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/emp")
public class EmployController {
    @Autowired
    private EmpDao empDao;
    @PostMapping(value = "/add")
    public String addTemp(Employee employee){
        System.out.println("lastname:"+employee.getLastName());
        int i = empDao.addEmp(employee);
        if (i>0){
            return "ok";
        }else {
            return "error";
        }
    }
    @PostMapping("/update")
    public String updateTemp(Employee employee){
        int i = empDao.updateEmp(employee);
        if (i>0){
            return "ok";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable String id){
        Employee emp = empDao.findEmp(id);
        ModelAndView modelAndView=new ModelAndView();
        if (emp!=null){
            Integer gender = emp.getGender();
            String sex;
            if (gender==0){
                sex="男";
            }else {
                sex="女";
            }
            modelAndView.setViewName("emp");
            modelAndView.addObject("sex",sex);
            modelAndView.addObject("emp",emp);
        }else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
    @GetMapping("/removeById/{id}")
    public String removeById(@PathVariable String id){
        String view=null;
        int i = empDao.removeEmp(id);
        if (i==0){
            view="error";
        }else {
            view="ok";
        }
        return view;
    }

}
