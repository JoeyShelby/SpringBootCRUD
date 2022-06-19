package org.joey.dao;

import org.joey.pojo.Department;
import org.joey.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: JoeyShelby
 * @date: 2022-06-14 15:28
 */
@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void testGetNextId() {
        System.out.println(employeeDao.getNextId());
    }

    @Test
    public void testListAllEmployees() {
        employeeDao.listAllEmployees().forEach(System.out::println);
    }

    @Test
    public void testCountEmployees() {
        System.out.println(employeeDao.countEmployees());
    }

    @Test
    public void testSaveEmployee() {
        System.out.println(employeeDao.saveEmployee(new Employee(employeeDao.getNextId(), "xqx", 1, departmentDao.getDepartmentById(3))));
        employeeDao.listAllEmployees().forEach(System.out::println);
    }

    @Test
    public void testRemoveEmployeeById() {
        System.out.println(employeeDao.removeEmployeeById(1008));
        employeeDao.listAllEmployees().forEach(System.out::println);
    }

    @Test
    public void testUpdateEmployee() {
        System.out.println(employeeDao.updateEmployee(new Employee(1002, "修改", 1, departmentDao.getDepartmentById(5))));
        employeeDao.listAllEmployees().forEach(System.out::println);
    }




}
