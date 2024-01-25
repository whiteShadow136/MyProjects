package org.example.relationship;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.example.config.RedisUtil;
import org.example.entity.RelationShip;
import org.example.util.RocketMqUtil;
import org.example.vo.RelationShipVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;

/**
 * @Description:org.example.relationship
 * @Date:2024/1/20
 * @Author:谢锦创
 */
@Service
public class RelationShipService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RocketMqUtil rocketMqUtil;

    @Value("${rocketmq.consumer.topic}")
    String topic;

    public static final String relationShipKey = "relationShipKey";

    public static Map<Class, RelationShipVO> SOURCE_CACHE = new HashMap<>();

    void putRelationShipIntoCache() {
        if (SOURCE_CACHE.isEmpty()) {
            getCacheFromRedis();
        } else {
            refreshCache();
        }
    }

//    @PostConstruct
//    void receiveUpdate() throws IOException, TimeoutException {
//        RocketMqUtil.Receive();
//    }

    public void getCacheFromRedis() {
        Object o = redisUtil.get(relationShipKey);
        if (o != null) {
            List<RelationShipVO> relationShipVOS = JSON.parseObject(o.toString(), new TypeReference<List<RelationShipVO>>() {
            });
            for (RelationShipVO relationShipVO : relationShipVOS) {
                SOURCE_CACHE.put(relationShipVO.getSrcClass(), relationShipVO);
            }
        }
    }

    public void refreshCache() {
        Query query = entityManager.createQuery("from " + RelationShip.class.getSimpleName());
        List<RelationShip> resultList = query.getResultList();
        Object json = JSON.toJSON(resultList);
        redisUtil.set(relationShipKey, JSON.toJSONString(json));
        rocketMqUtil.send(topic, "update");
    }

}
