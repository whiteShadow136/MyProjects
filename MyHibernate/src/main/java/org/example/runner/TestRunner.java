package org.example.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description:org.example.runner
 * @Date:2024/1/21
 * @Author:谢锦创
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TestRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(2222);
    }
}
