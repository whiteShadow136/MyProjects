package com.example.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description:com.example.runner
 * @Date:2023/11/20
 * @Author:谢锦创
 */
@Component
//@Order(1)
public class LoadAgentApplicationRunner2 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(1111);
        System.out.println(System.setProperty("server.port", "8010"));
    }
}
