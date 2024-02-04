package org.example.config;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description:org.example.config
 * @Date:2024/2/4
 * @Author:谢锦创
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolTaskExecutor threadPoolExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 初始线程数，也是最小线程数
        threadPoolTaskExecutor.setCorePoolSize(5);
        // 能同时运行的最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(10);
        // 队列的最大长度
        threadPoolTaskExecutor.setQueueCapacity(100);
        threadPoolTaskExecutor.setThreadNamePrefix("custom-thread-%d");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
