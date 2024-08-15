package org.example.costMonitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.costMonitor.Cost;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Aspect
public class CostAspect {
    Map<String, Cost> beanCostMap = new HashMap<>();

    Field identifierField;

    public CostAspect() {
        try {
            identifierField = Class.forName("org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMethod")
                    .getDeclaredField("identifier");
            identifierField.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Cost getBeanCost(String beanName) {
        Cost cost = beanCostMap.get(beanName);
        if (cost == null) {
            cost = new Cost();
            beanCostMap.put(beanName, cost);
        }
        return cost;
    }

    @Around("execution(* org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.LifecycleMethod.invoke(Object))")
    public Object LifecycleMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object bean = args[0];
        String key = bean.toString();

        Object target = joinPoint.getTarget();
        Object identifier = identifierField.get(target);
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long costTime = System.currentTimeMillis() - start;
            Cost cost = getBeanCost(key);
            cost.add("LifecycleMethod " + identifier + "()", costTime);
        }
    }

    @AfterReturning("execution(* org.springframework.boot.SpringApplication.run(java.lang.Class<?>, java.lang.String...))")
    public void run(JoinPoint joinPoint) {

        beanCostMap.entrySet().stream().sorted((o1, o2) -> (int) (o2.getValue().getAllCost() - o1.getValue().getAllCost())).forEach(e -> {

            Cost cost = e.getValue();
            long allCost = cost.getAllCost();
            if (allCost < 3) {
                return;
            }
            System.out.println(e.getKey() + ":" + allCost + " (" + cost.phases.stream().map(a -> a.phase + ":" + a.cost).collect(Collectors.joining(",")) + ")");
        });
    }


}
