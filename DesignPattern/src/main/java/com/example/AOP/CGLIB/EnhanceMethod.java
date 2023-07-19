package com.example.AOP.CGLIB;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:谢锦创
 * @Date:2023/7/12
 * @Description:com.example.AOP.CGLIB
 * @VERSION:1.0
 */
public class EnhanceMethod implements InvocationHandlerTest {
    @Override
    public Object invoke() {
        System.out.println("前置操作");
        return null;
    }
}
