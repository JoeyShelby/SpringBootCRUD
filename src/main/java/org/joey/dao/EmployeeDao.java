package org.joey.dao;

import org.joey.pojo.Department;
import org.joey.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: JoeyShelby
 * @date: 2022-06-14 14:42
 */
@Repository
public class EmployeeDao {
    // 模拟数据
    private static Map<Integer, Employee> employees = null;
    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"A",1,new Department(1,"保卫处")));
        employees.put(1002,new Employee(1002,"B",0,new Department(2,"后勤部")));
        employees.put(1003,new Employee(1003,"C",1,new Department(3,"学工处")));
        employees.put(1004,new Employee(1004,"D",0,new Department(4,"教务处")));
        employees.put(1005,new Employee(1005,"E",1,new Department(5,"财务处")));
    }

    public static Integer getNextId() {
        return employees.size()+1001;
    }

    /*增删改查*/
    public List<Employee> listAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public Integer countEmployees() {
        return employees.size();
    }

    public Integer saveEmployee(Employee employee) {
        int count = employees.size();
        employees.put(employee.getId(), employee);
        return employees.size() - count;
    }

    public Integer removeEmployeeById(Integer id) {
        int count = employees.size();
        employees.remove(id);
        return count - employees.size();
    }

    public Employee updateEmployee(Employee employee) {
        employees.put(employee.getId(),employee);
        return this.getEmployeeById(employee.getId());
    }
}
