package org.example;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Description:org.example
 * @Date:2023/11/4
 * @Author:谢锦创
 */
@Component
public class ApplicationContextUtil {

    public static ConfigurableApplicationContext context = null;

    @Autowired
    Environment environment;

    public static<T> T getBean(Class<T> clazz) {
        T bean = context.getBean(clazz);
        return bean;
    }

    public static Environment getEnvironment(@Autowired Environment environment) {
        return environment;
    }
}
