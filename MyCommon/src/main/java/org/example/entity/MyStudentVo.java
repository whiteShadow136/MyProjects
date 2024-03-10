package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:org.example.entity
 * @Date:2024/3/10
 * @Author:谢锦创
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyStudentVo {
    private Student student;

    private String exaAttrStudent = "exaAttrStudent";

    public Student MyStudentVoToStudent(MyStudentVo myStudentVo) {
        return myStudentVo.getStudent();
    }

    public static MyStudentVo getRandomInstance() {
        MyStudentVo myStudentVo = new MyStudentVo();
        myStudentVo.setStudent(Student.getRandomInstance());
        return myStudentVo;
    }
}
