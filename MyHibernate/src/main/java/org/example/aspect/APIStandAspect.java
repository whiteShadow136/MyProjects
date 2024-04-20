package org.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:org.example.aspect
 * @Date:2024/4/14
 * @Author:谢锦创
 */
@Aspect
@Component
@Slf4j
public class APIStandAspect {

    @Pointcut("execution(* org.example.controller..*(..))")
    public void monitor(){}

    @Around("monitor()")
    public Object monitorExeTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录开始时间
        long startTime = System.nanoTime();
        Object result = joinPoint.proceed(); // continue on the intercepted method
        // 记录结束时间
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double seconds = duration / 1_000_000_000.0;
        System.out.println("方法执行时间： " + seconds + " 秒");

        log.info("Method [{}] executed in [{}] ms", joinPoint.getSignature().toShortString(), seconds);
        System.out.println("APIStandAspect");
        return result;
    }
}
