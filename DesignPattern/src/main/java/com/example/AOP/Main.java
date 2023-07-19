package com.example.AOP;

import com.example.AOP.Exception.FileNotFound;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description:com.example.AOP
 *
 * @Date:2023/7/17
 * @Author:谢锦创
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        FileNotFound fileNotFound = context.getBean(FileNotFound.class);
        fileNotFound.play();
        System.out.println(111);
    }
}
