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
public class ResultVoAspect {

    @Pointcut("execution(* org.example.controller..*(..))")
    public void monitor(){}

    @Around("monitor()")
    public Object monitorExeTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // continue on the intercepted method
        long elapsedTime = System.currentTimeMillis() - start;

        log.info("Method [{}] executed in [{}] ms", joinPoint.getSignature().toShortString(), elapsedTime);
        System.out.println("ResultVoAspect");
        return result;
    }

}
