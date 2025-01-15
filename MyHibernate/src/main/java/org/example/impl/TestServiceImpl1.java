package org.example.impl;

import org.example.entity.MyEntity;
import org.example.service.TestService;
import org.example.thread.ThreadLocalUtil;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Description:org.example.impl
 * @Date:2024/8/7
 * @Author:谢锦创
 */
@Service
@Primary
public class TestServiceImpl1 implements TestService {

    @Autowired
    private EntityManager entityManager;

    @Async
    @Override
    @Transactional
    public void asyncOfThreadLocal() {
        ThreadLocalUtil.set(new MyEntity());
        System.out.println(11111);
    }

    @Async
    @Override
//    @Transactional
    public List selectTask() {
        String sql = "select * from UserVoTest";
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        if (1 == 1) {
            throw new RuntimeException("测试异常");
        }
        return query.getResultList();

    }
}
