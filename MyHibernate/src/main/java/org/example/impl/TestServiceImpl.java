package org.example.impl;

import org.aspectj.weaver.ast.Test;
import org.example.entity.MyEntity;
import org.example.service.TestService;
import org.example.thread.ThreadLocalUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Description:org.example.impl
 * @Date:2024/8/7
 * @Author:谢锦创
 */
@Service
public class TestServiceImpl implements TestService {

    @Async
    @Override
    @Transactional
    public void asyncOfThreadLocal() {
        ThreadLocalUtil.set(new MyEntity());
        System.out.println(11111);
    }
}
