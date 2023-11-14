package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @Description:org.example.pojo
 * @Date:2023/11/6
 * @Author:谢锦创
 */
@Data
//@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id1;
    String name;
}
