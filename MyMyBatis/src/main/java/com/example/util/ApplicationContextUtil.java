package com.example.util;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:com.example.util
 * @Date:2023/9/23
 * @Author:谢锦创
 */
public class ApplicationContextUtil {
    public static ConfigurableApplicationContext applicationContext = null;

    public static<T>  T getBean(Class clazz) {
        T bean = (T)applicationContext.getBean(clazz);
        return bean;
    }
}
