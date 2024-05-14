package org.example.beanfactory;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:org.example.beanfactory
 * @Date:2024/5/8
 * @Author:谢锦创
 */
public class MyClassPathXmlExtend extends ClassPathXmlApplicationContext {

    public MyClassPathXmlExtend(String... configLocations) throws BeansException {
        super(configLocations);
    }

    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        beanFactory.setAllowBeanDefinitionOverriding(false);
        beanFactory.setAllowCircularReferences(false);
        super.customizeBeanFactory(beanFactory);
    }
}
