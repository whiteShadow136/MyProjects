package com.example.AOP.Exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Aspect
//@Component
public class ExceptionHandlerAspect {

    @Around("execution(* com.example.AOP.Exception.FileNotFound.play(..))")
    public void handleFileNotFoundException(ProceedingJoinPoint joinPoint) throws Throwable {
        // 在此处编写您希望执行的异常处理逻辑
        // 您可以在这里记录日志、发送警报、返回自定义错误消息等等
        System.out.println("文件未找到异常已被拦截");
    }
}
