package org.example.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Description:org.example.proxy.cglib
 * @Date:2024/9/8
 * @Author:谢锦创
 */
public class Main {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        CommonClass commonClass = proxyFactory.getProxy(CommonClass.class, new MyMethodInterceptor());
        commonClass.print();
    }
}

