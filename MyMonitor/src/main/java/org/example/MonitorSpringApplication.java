package org.example;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:org.example
 * @Date:2024/7/28
 * @Author:谢锦创
 */
@SpringBootApplication
@EnableAdminServer
public class MonitorSpringApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MonitorSpringApplication.class);
        System.out.println(context);
        
    }
}
