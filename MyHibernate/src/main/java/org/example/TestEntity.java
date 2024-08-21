package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:PACKAGE_NAME
 * @Date:2024/5/7
 * @Author:谢锦创
 */
@Data
@NoArgsConstructor
public class TestEntity {
    String name;

    public TestEntity(String name) {
        System.out.println("this is MyHibernate");
        this.name = name;
    }
}
