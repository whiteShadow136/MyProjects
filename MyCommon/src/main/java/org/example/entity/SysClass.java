package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * @Description:org.example.entity
 * @Date:2023/12/20
 * @Author:谢锦创
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysClass {
    private Integer id;
    private String name;
    private String teacher;
    private String classRoom;
    private Student student;

    public static SysClass getRandomInstance() {
        SysClass sysClass = new SysClass();
        Random random = new Random();
        sysClass.setId(random.nextInt(1000));
        sysClass.setClassRoom("教室");
        sysClass.setName("教室");
        sysClass.setStudent(Student.getRandomInstance());
        return sysClass;
    }
}
