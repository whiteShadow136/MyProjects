package org.example;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:org.example
 * @Date:2023/11/4
 * @Author:谢锦创
 */
public class ApplicationContextUtil {

    public static ConfigurableApplicationContext context = null;

    static Object getBean(Class clazz) {
        return context.getBean(clazz);
    }
}
