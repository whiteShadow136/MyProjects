package org.example.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @Description:org.example.proxy.cglib
 * @Date:2024/9/8
 * @Author:谢锦创
 */
public class ProxyFactory {
    Enhancer enhancer = new Enhancer();


    public<T> T getProxy(Class<T> targetClass, MethodInterceptor methodInterceptor){
        // 为什么设置一个拦截器要new出来一个对象? 因为到时候这个拦截器会被代理调用过去，所以直接new出来传过去就可以了
        enhancer.setCallback(methodInterceptor);
        enhancer.setSuperclass(targetClass);
        return  (T)enhancer.create();
    }
}
