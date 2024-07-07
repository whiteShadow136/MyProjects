package org.example.entity;

/**
 * @Description:org.example.entity
 * @Date:2024/7/6
 * @Author:谢锦创
 */
public class MyCalculator implements Calculator{

    @Override
    public Integer add(int a, int b) {
        return a + b;
    }
}
