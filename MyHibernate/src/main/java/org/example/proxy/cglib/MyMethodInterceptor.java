package org.example.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description:org.example.proxy.cglib
 * @Date:2024/9/8
 * @Author:谢锦创
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method");
        Object result = methodProxy.invokeSuper(o , objects);
        System.out.println("after method");
        return null;
    }
}
