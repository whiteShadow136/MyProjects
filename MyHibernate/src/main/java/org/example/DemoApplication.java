package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Indexed;

@Indexed
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContextUtil.context = SpringApplication.run(DemoApplication.class, args);
    }

}
