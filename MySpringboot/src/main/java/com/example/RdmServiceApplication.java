package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:com.example
 * @Date:2023/9/15
 * @Author:谢锦创
 */
@SpringBootApplication
@PropertySource(value = {"classpath:application-abc.properties","classpath:application-xdm.properties"},
        ignoreResourceNotFound = true)
public class RdmServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RdmServiceApplication.class);
        System.setProperty("names1", "123");
        System.out.println(1111);

    }
}
