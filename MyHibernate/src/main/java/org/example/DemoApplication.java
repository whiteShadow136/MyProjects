package org.example;

import org.example.beanfactory.MyClassPathXmlExtend;
import org.example.util.ApplicationContextUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Indexed;

import java.time.LocalDateTime;

@Indexed
@EnableAsync
@EntityScan("org.example.entity")
@SpringBootApplication
@EnableAspectJAutoProxy
@ServletComponentScan
public class DemoApplication {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
//                MyClassPathXmlExtend("spring-${xing${name}}.xml");
//        System.out.println(1111);
//        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.out.println(LocalDateTime.now());
        ConfigurableApplicationContext context = new SpringApplicationBuilder(DemoApplication.class)
        .applicationStartup(new BufferingApplicationStartup(20480))
            .run(args);
        ApplicationContextUtil.context = context;
        System.out.println("启动完成");
        System.out.println(LocalDateTime.now());
    }

}
