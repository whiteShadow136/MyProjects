package com.example;

import com.example.controller.MyBatisDemo;
import com.example.util.ApplicationContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description:com.example
 * @Date:2023/9/17
 * @Author:谢锦创
 */
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class RdmServiceMybatis {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RdmServiceMybatis.class);
        ApplicationContextUtil.applicationContext = context;
//        MyBatisDemo myBatisDemo = new MyBatisDemo();
//        myBatisDemo.userExecute("user", 1);
//        myBatisDemo.userExecute("user", 2);
//        myBatisDemo.userExecute("user", 3);
//        myBatisDemo.userExecute("user", 4);
//        myBatisDemo.userExecute("user", 5);
//        myBatisDemo.userExecute("user", 6);
    }
}
