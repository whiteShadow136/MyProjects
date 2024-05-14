package org.example.base;

import org.example.TestEntity;

/**
 * @Description:org.example.base
 * @Date:2024/5/6
 * @Author:谢锦创
 */
public class Main {
    public static void main(String[] args) {
        TestAbstract testAbstract = new TestAbstract();
        testAbstract.run();

        TestEntity testEntity = new TestEntity();
        System.out.println(testEntity.getNameEn());
    }
}
