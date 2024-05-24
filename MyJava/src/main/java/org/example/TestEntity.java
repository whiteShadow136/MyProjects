package org.example;

import lombok.Data;

/**
 * @Description:org.example
 * @Date:2024/5/7
 * @Author:谢锦创
 */
@Data
public class TestEntity {
    String nameEn;

    public TestEntity() {
        System.out.println("this is MyJava");
    }
}
