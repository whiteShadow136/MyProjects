package org.example;

import lombok.Data;

/**
 * @Description:PACKAGE_NAME
 * @Date:2024/5/7
 * @Author:谢锦创
 */
@Data
public class TestEntity {
    String name;

    public TestEntity(String name) {
        System.out.println("this is MyHibernate");
        this.name = name;
    }
}
