package org.joey.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: JoeyShelby
 * @date: 2022-06-14 14:34
 */

@Component
@Data
@NoArgsConstructor
@ToString
public class Employee {
    private Integer id;
    private String name;
    private Date birth;
    private Integer gender;
    private Department department;

    public Employee(Integer id, String name, Integer gender, Department department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
