package org.example.impl;

import org.example.entity.SysUser;
import org.example.event.PostStoreEvent;
import org.example.event.PreStoreEvent;
import org.example.service.UserService;
import org.example.util.RequestContext;
import org.example.util.RequestContextManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @Description:org.example.impl
 * @Date:2024/1/30
 * @Author:谢锦创
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    @Qualifier("MyThreadPoolExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    @Transactional
    public SysUser getUser(String id) {
        SysUser sysUser = entityManager.find(SysUser.class, id);
//        applicationEventPublisher.publishEvent(new PreStoreEvent(sysUser));
        System.out.println(sysUser);
//        applicationEventPublisher.publishEvent(new PostStoreEvent(sysUser));
        return sysUser;
    }

    @Async
    @Transactional
    public void asyncMethodA() {
        System.out.println(1111);
        RequestContext current = RequestContextManager.getCurrent();
        System.out.println(current);
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(11111);
//            return "asyncMethodA";
//        }, threadPoolTaskExecutor);
        // ...
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(11111);
//        return CompletableFuture.completedFuture("asyncMethodA");
    }

    @Async
    @Transactional
    public void asyncMethodB() {
//        try {
//            completableFuture.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
        // ...
        System.out.println(22222);
        RequestContext current = RequestContextManager.getCurrent();
        System.out.println(current);
//        return CompletableFuture.completedFuture("asyncMethodA");
    }
}
