package com.example.AOP.CGLIB;
//
///**
// * @Author:谢锦创
// * @Date:2023/7/15
// * @Description:com.example.AOP.CGLIB
// * @VERSION:1.0
// */
//public class ClassInstance extends EnhanceMethod implements MethodInterface{
//
//    Object realBean = new SimpleMethod();
//
//    @Override
//    public void play() {
//        Object returnObject = invoke();
//        ((SimpleMethod)realBean).play();
//    }
//
//}


import com.example.AOP.CGLIB.EnhanceMethod;
import com.example.AOP.CGLIB.MethodInterface;
import com.example.AOP.CGLIB.SimpleMethod;

import java.lang.Object;

public class ClassInstance extends EnhanceMethod implements MethodInterface {
    public Object realBean = new SimpleMethod();

    public void play() {
        Object returnObject = invoke();
//        ((SimpleMethod)realBean).play();
    }
}
