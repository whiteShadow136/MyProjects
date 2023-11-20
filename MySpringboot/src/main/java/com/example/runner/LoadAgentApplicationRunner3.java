package com.example.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Description:com.example.runner
 * @Date:2023/11/20
 * @Author:谢锦创
 */
@Component
//@Order(2)
public class LoadAgentApplicationRunner3 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.setProperty("server.port", "8010");
        System.out.println(2222);
    }
}
