package org.example.entity;

import lombok.Data;

import java.util.UUID;

/**
 * @Description:org.example.entity
 * @Date:2023/12/20
 * @Author:谢锦创
 */
@Data
public class Student {
    String id;

    String name;

    public static Student getRandomInstance() {
        Student student = new Student();
        student.setId(UUID.randomUUID().toString().replace("-", ""));
        student.setName("学生");
        return student;
    }
}
