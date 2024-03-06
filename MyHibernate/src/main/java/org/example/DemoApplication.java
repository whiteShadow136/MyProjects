package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Indexed;

import java.time.LocalDateTime;

@Indexed
@EnableAsync
@EntityScan("org.example.entity")
@SpringBootApplication
@ServletComponentScan
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        ApplicationContextUtil.context = SpringApplication.run(DemoApplication.class, args);
        System.out.println("启动完成");
        System.out.println(LocalDateTime.now());
    }

}
