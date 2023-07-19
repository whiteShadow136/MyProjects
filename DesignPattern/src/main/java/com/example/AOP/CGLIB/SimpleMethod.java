package com.example.AOP.CGLIB;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:谢锦创
 * @Date:2023/7/12
 * @Description:com.example.AOP.CGLIB
 * @VERSION:1.0
 */
public class SimpleMethod extends EnhanceMethod {
    
    public void play() {
        System.out.println(1111);
    }

    interface face{
        void foo();
    }
    
    class innerMethod implements face{

        @Override
        public void foo() {
            System.out.println("foo...");
        }
    }

    public SimpleMethod() {
    }

    public static void main(String[] args) {

        innerMethod innerMethod = new SimpleMethod().new innerMethod();
        face proxy = (face)Proxy.newProxyInstance(SimpleMethod.class.getClassLoader(), new Class[]{face.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before....");
                        method.invoke(innerMethod, args);
                        return null;
                    }
                });

        proxy.foo();

        SimpleMethod methodProxy= (SimpleMethod)Enhancer.create(SimpleMethod.class, new MethodInterceptor() {

                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        System.out.println("before....");
                        proxy.invoke(this, args);
                        System.out.println("after....");
                        return null;
                    }
                }
        );
        methodProxy.play();
    }

}
