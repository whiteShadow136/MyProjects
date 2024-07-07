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
    public static Calculator getProxy(final Calculator calculator) {
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = classLoader.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    result = method.invoke(calculator, args);
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
