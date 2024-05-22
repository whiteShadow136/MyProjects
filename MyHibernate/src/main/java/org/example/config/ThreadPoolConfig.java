package org.example.config;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.example.util.RequestContext;
import org.example.util.RequestContextManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
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

    @Bean("MyThreadPoolExecutor")
    public ThreadPoolTaskExecutor threadPoolExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 初始线程数，也是最小线程数
        threadPoolTaskExecutor.setCorePoolSize(2);
        // 能同时运行的最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(3);
        // 队列的最大长度
        threadPoolTaskExecutor.setQueueCapacity(2);
        threadPoolTaskExecutor.setThreadNamePrefix("custom-thread-%d");
        threadPoolTaskExecutor.setTaskDecorator(new MyTaskDecorator());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    class MyTaskDecorator implements TaskDecorator {

        @Override
        public Runnable decorate(Runnable runnable) {
            RequestContext current = RequestContextManager.getCurrent();
            return () -> {
                try {
                    RequestContextManager.setCurrent(current);
                    // 在执行任务前设置上下文
                    runnable.run();
                } finally {
                    // 任务执行后清理上下文
                    RequestContextManager.remove();
                }
            };
        }
    }
}
