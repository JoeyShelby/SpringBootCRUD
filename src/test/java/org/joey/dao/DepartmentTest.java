package org.joey.dao;

import org.joey.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: JoeyShelby
 * @date: 2022-06-14 15:13
 */
@SpringBootTest
public class DepartmentTest {

    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void testListAllDepartments() {
        List<Department> departments = departmentDao.listAllDepartments();
        departments.forEach(System.out::println);
    }

    @Test
    public void testGetDepartmentById() {
        System.out.println(departmentDao.getDepartmentById(3));
    }

    @Test
    public void testCountDepartments() {
        System.out.println(departmentDao.countDepartments());
    }

    @Test
    public void testSaveDepartment() {
        System.out.println(departmentDao.saveDepartment(new Department(departmentDao.getNextId() + 1, "其他")));
    }

    @Test
    public void testGetNextId() {
        System.out.println(departmentDao.getNextId());
    }

    @Test
    public void removeDepartmentById() {
        System.out.println(departmentDao.removeDepartmentById(2));
        System.out.println(departmentDao.listAllDepartments());
    }

    @Test
    public void testUpdateDepartment() {
        System.out.println(departmentDao.updateDepartment(new Department(2, "修改")));
        System.out.println(departmentDao.listAllDepartments());
    }
}
