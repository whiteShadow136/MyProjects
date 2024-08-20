package org.example.util;

import org.hibernate.cfg.Environment;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Description:org.example
 * @Date:2023/11/4
 * @Author:谢锦创
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    public static ApplicationContext context = null;

//    @Autowired
//    Environment environment;

    public static<T> T getBean(Class<T> clazz) {
        T bean = context.getBean(clazz);
        return bean;
    }

    public static<T> T getBean(String name, Class<T> clazz) {
        T bean = context.getBean(name, clazz);
        return bean;
    }

    public static Environment getEnvironment(@Autowired Environment environment) {
        return environment;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
