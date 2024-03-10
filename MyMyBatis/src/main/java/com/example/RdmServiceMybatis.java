package com.example;

import com.example.controller.MyBatisDemo;
import com.example.util.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @Description:com.example
 * @Date:2023/9/17
 * @Author:谢锦创
 */
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
@Slf4j
public class RdmServiceMybatis {
    public static void main(String[] args) {
        log.info("开始启动时间{}", LocalDateTime.now());
        ConfigurableApplicationContext context = SpringApplication.run(RdmServiceMybatis.class);
        log.info("结束启动时间{}", LocalDateTime.now());
        log.info("启动成功");
    }
}
