package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:org.example
 * @Date:${DATE}
 * @Author:谢锦创 http://localhost:8081/swagger-ui.html
 */

@SpringBootApplication
@EnableSwagger2
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!1111");
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);

    }
}