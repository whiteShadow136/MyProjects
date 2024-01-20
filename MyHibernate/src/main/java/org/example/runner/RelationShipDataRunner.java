package org.example.runner;

import lombok.extern.slf4j.Slf4j;
import org.example.config.RedisUtil;
import org.example.entity.MyEntity;
import org.example.entity.RelationShip;
import org.example.entity.User;
import org.example.relationship.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Description:org.example.runner
 * @Date:2024/1/20
 * @Author:谢锦创
 */
@Component
@Slf4j
public class RelationShipDataRunner implements ApplicationRunner {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    RelationShipService relationShipService;

    @Autowired
    RedisUtil redisUtil;

    public static final String lockKey = "lock";

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Thread.sleep(10000);
        try {
            Query query = entityManager.createQuery("from " + RelationShip.class.getSimpleName());
            //        if (query.getResultList().isEmpty()) {
                RelationShip relationShip = RelationShip.builder()
                        .srcClass(MyEntity.class)
                        .srcClassNameEn(MyEntity.class.getSimpleName())
                        .targetClass(User.class)
                        .targetClassNameEn(User.class.getSimpleName()).build();
                entityManager.merge(relationShip);
            //        }
            relationShipService.refreshCache();
        } catch (Exception e) {
            log.error("缓存刷新失败");
        }


    }
}
