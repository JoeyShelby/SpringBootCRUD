package org.joey.dao;

import org.joey.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author: JoeyShelby
 * @date: 2022-06-14 14:42
 */
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    /**
     * 模拟数据库数据
     */
    static {
        departments = new HashMap<>();
        departments.put(1,new Department(1,"保卫处"));
        departments.put(2,new Department(2,"后勤部"));
        departments.put(3,new Department(3,"学工处"));
        departments.put(4,new Department(4,"教务处"));
        departments.put(5,new Department(5,"财务处"));
    }

    public static Integer getNextId() {
        return departments.size()+1;
    }

    /**
     * 增删改查
     */
    public List<Department> listAllDepartments() {
        return new ArrayList<>(departments.values());
    }

    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }

    public Integer countDepartments() {
        return departments.size();
    }

    public Integer saveDepartment(Department department) {
        int count = departments.size();
        departments.put(department.getId(), department);
        return departments.size() - count;
    }

    public Integer removeDepartmentById(Integer id) {
        int count = departments.size();
        departments.remove(id);
        return count - departments.size();
    }

    public Department updateDepartment(Department department) {
        departments.put(department.getId(),department);
        return this.getDepartmentById(department.getId());
    }



}
