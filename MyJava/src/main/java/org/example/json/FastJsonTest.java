package org.example.json;

import com.alibaba.fastjson.JSON;
import org.example.entity.Student;
import org.example.entity.SysClass;
import org.example.entity.SysUser;

import java.time.LocalDateTime;

/**
 * @Description:org.example.json
 * @Date:2023/12/20
 * @Author:谢锦创
 */
public class FastJsonTest {
    public static void main(String[] args) {
        FastJsonTest testJson = new FastJsonTest();
        testJson.play();
    }

    void play() {

        String json = "{\"name\":\"张三\", \"id\":30}";
        Student student = JSON.parseObject(json, Student.class);
        System.out.println(student.getId());
        System.out.println(student.getName());

        SysClass sysClass = SysClass.builder()
                .name("超级一班")
                .student(student)
                .build();
        String clazzString = JSON.toJSONString(sysClass);
        LocalDateTime.now();
        System.out.println(clazzString);
    }
}
