package org.joey.controller;

import org.joey.dao.DepartmentDao;
import org.joey.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: JoeyShelby
 * @date: 2022-06-17 09:11
 */
@RestController
public class DepartmentController {
    DepartmentDao departmentDao;
    @Autowired
    public DepartmentController(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


    @GetMapping("/departments")
    public List<Department> listDepartments() {
        List<Department> departments = departmentDao.listAllDepartments();
        return departments;
    }
}
