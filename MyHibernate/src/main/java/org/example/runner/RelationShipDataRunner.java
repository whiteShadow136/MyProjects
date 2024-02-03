package org.example.runner;

import lombok.extern.slf4j.Slf4j;
import org.example.config.RedisUtil;
import org.example.relationship.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @Description:org.example.runner
 * @Date:2024/1/20
 * @Author:谢锦创
 */
@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RelationShipDataRunner implements ApplicationRunner {

    @Autowired
    private EntityManager entityManager;

    @Autowired(required = false)
    RelationShipService relationShipService;

    @Autowired(required = false)
    RedisUtil redisUtil;

    public static final String lockKey = "lock";

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(11111);

//        Thread.sleep(10000);
//        try {
//            Query query = entityManager.createQuery("from " + RelationShip.class.getSimpleName());
//            //        if (query.getResultList().isEmpty()) {
//                RelationShip relationShip = RelationShip.builder()
//                        .srcClass(MyEntity.class)
//                        .srcClassNameEn(MyEntity.class.getSimpleName())
//                        .targetClass(User.class)
//                        .targetClassNameEn(User.class.getSimpleName()).build();
//                entityManager.merge(relationShip);
//            //        }
//            relationShipService.refreshCache();
//        } catch (Exception e) {
//            log.error("缓存刷新失败");
//        }


    }
}
