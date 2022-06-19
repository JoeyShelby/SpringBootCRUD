package org.joey.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author: JoeyShelby
 * @date: 2022-06-14 14:34
 */

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
    private Integer id;
    private String name;
}
