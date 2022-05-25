package com.test.rest.dao;

import com.test.rest.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class EmpDaoImpl implements EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * @param employee
     * @return int
     */
    @Override
    public int addEmp(Employee employee) {
        int cont=0;
        String sql="insert into employee(lastname,gender,email) values (?,?,?)";
        try {
            cont=jdbcTemplate.update(sql,employee.getLastName(),
                    employee.getGender(),employee.getEmail());
        }catch (Exception e){
            e.printStackTrace();
        }
        return cont;
    }
    /**
     * @param id
     * @return
     */
    @Override
    public int removeEmp(String id) {
        String sql="delete from employee where id=?";
        int update=0;
        try {
            update= jdbcTemplate.update(sql, id);
        }catch (Exception e){
            update=0;
            e.printStackTrace();
        }
        return update;
    }
    /**
     * @param employee
     * @return
     */
    @Override
    public int updateEmp(Employee employee) {
        String sql="update employee set lastname=?,email=?,gender=? where id=?";
        return jdbcTemplate.update(sql,employee.getLastName(),employee.getEmail(),
                employee.getGender(),employee.getId());
    }
    /**
     * @param id
     * @return
     */
    @Override
    public Employee findEmp(String id) {
        Employee employee=null;
        int i = selectCount();
        if (i!=0){
            try {
                String sql="select * from employee where id=?";
                employee =
                        jdbcTemplate.queryForObject
                                (sql, new BeanPropertyRowMapper<Employee>
                                        (Employee.class), id);
            }catch (Exception e){
                employee=null;
                e.printStackTrace();
            }
            return employee;
        }else {
            return null;
        }
    }
    /**
     * @return int
     */
    @Override
    public int selectCount() {
        String sql="select count(*) from employee";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
    /**
     * @return List<Employee>
     */
    @Override
    public List<Employee> findAll() {
        String sql="select * from employee";
        List<Employee> employees = jdbcTemplate.
                query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
        return employees;
    }

}
