package org.joey.controller;

import org.joey.dao.DepartmentDao;
import org.joey.dao.EmployeeDao;
import org.joey.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: JoeyShelby
 * @date: 2022-06-17 09:48
 */
@Controller
public class EmployeeController {
    EmployeeDao employeeDao;
    DepartmentDao departmentDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao, DepartmentDao departmentDao) {
        this.employeeDao = employeeDao;
        this.departmentDao = departmentDao;
    }

    @PostMapping("saveEmployee")
    public String  saveEmployee(String name,Integer gender,Integer deptId) {
        System.out.println(name+gender+deptId);
        Employee employee = new Employee(EmployeeDao.getNextId(),name,gender,departmentDao.getDepartmentById(deptId));
        employeeDao.saveEmployee(employee);
        return "main";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") Integer id) {
        employeeDao.removeEmployeeById(id);

        return "main";
    }


}
