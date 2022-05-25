package com.test.rest.dao;

import com.test.rest.bean.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDao {
    //增
    int addEmp(Employee employee);
    //删
    int removeEmp(String id);
    //改
    int updateEmp(Employee employee);
    //查
    Employee findEmp(String id);
    //查询多少行
    int selectCount();
    //查询所有对象
    List<Employee> findAll();
}
