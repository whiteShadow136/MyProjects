package org.example.proxy;

import org.example.entity.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:org.example.proxy
 * @Date:2024/7/6
 * @Author:谢锦创
 */
public class CalculatorProxy {
    public <T> T getProxy(final T object) {
        ClassLoader classLoader = object.getClass().getClassLoader();
//        Class<?>[] interfaces = classLoader.getClass().getInterfaces();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println(11112);
                    result = method.invoke(object, args);
                    System.out.println(2222);
                } catch (Exception e) {

                } finally {
                    return result;
                }
            }
        };
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (T) proxy;
    }

    public static Calculator getProxyTest(final Calculator calculator) {
        ClassLoader classLoader = calculator.getClass().getClassLoader();
//        Class<?>[] interfaces = classLoader.getClass().getInterfaces();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println(11112);
                    result = method.invoke(calculator, args);
                    System.out.println(2222);
                } catch (Exception e) {

                } finally {
                    return result;
                }
            }
        };
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (Calculator) proxy;
    }
}
