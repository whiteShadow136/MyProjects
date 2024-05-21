package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:org.example
 * @Date:${DATE}
 * @Author:谢锦创
 */
@SpringBootApplication
@EnableFeignClients
public class FeignApplicationService {
    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(FeignApplicationService.class);
//        System.out.println(1111);

        new SpringApplicationBuilder(FeignApplicationService.class)
                .applicationStartup(new BufferingApplicationStartup(20480))
                .run(args);
    }
}