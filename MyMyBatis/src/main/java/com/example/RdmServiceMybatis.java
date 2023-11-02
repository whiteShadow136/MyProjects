package com.example;

import com.example.controller.MyBatisDemo;
import com.example.util.ApplicationContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * @Description:com.example
 * @Date:2023/9/17
 * @Author:谢锦创
 */
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class RdmServiceMybatis {
    public static void main(String[] args) {
// Create a ConfigurableApplicationContext object and assign it to the context variable
        ConfigurableApplicationContext context = SpringApplication.run(RdmServiceMybatis.class);
    MyEvent myEvent = new MyEvent("AA");
        context.publishEvent(myEvent);

// Assign the application context to the applicationContextUtil
        ApplicationContextUtil.applicationContext = context;
        ArrayList<Object> list = new ArrayList<>();
        // 遍历list并输出结果
        // 生成判断是否为字母的正则
        list.add("user");
//        AnnotationUtils.findAnnotation()

//        MyBatisDemo myBatisDemo = new MyBatisDemo();
//        myBatisDemo.userExecute("user", 1);
//        myBatisDemo.userExecute("user", 2);
//        myBatisDemo.userExecute("user", 3);
//        myBatisDemo.userExecute("user", 4);
//        myBatisDemo.userExecute("user", 5);
//        myBatisDemo.userExecute("user", 6);
    }
}
