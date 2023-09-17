package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:com.example
 * @Date:2023/9/15
 * @Author:谢锦创
 */
@SpringBootApplication
public class RdmServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RdmServiceApplication.class);
    }
}
