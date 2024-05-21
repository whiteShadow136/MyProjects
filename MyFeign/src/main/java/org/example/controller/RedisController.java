package org.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.example.entity.SysClass;
import org.example.entity.SysUser;
import org.example.enums.Cascade;
import org.example.enums.Result;
import org.example.vo.RelationShipVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @className: RedisController
 * @description:
 * @author: sh.Liu
 * @date: 2022-03-08 14:28
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    private static Map<Class<?>, List<RelationShipVO>> SOURCE_CACHE = new ConcurrentHashMap<>();

    private static Map<Class<?>, List<RelationShipVO>> TARGET_CACHE = new ConcurrentHashMap<>();

    static String sss = "abc";
    public RedisController() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("save")
    public Result save(@RequestParam String key,@RequestParam String value){
        redisTemplate.expire(key, 24, TimeUnit.HOURS);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.opsForHash().put("global","A:B:C", "D");
        redisTemplate.opsForHash().put("global","A:B:D", "D");
        redisTemplate.opsForHash().put("global","A:B:E", "D");
        redisTemplate.opsForHash().put("global","A:C:E", "D");

        HashOperations<String, String, Object> hashOps = redisTemplate.opsForHash();
// 获取符合前缀条件的所有键
        hashOps.keys("global").stream()
                .filter(per -> key.startsWith("A:B"))
                .forEach(per -> hashOps.delete("global", key));

        List keys = (List) redisTemplate.opsForHash().keys("global").stream().
                filter(per -> per.toString().startsWith("A:B")).collect(Collectors.toList());
        redisTemplate.opsForHash().delete("global", keys);
        for (int i = 0; i <= 100; i++) {
            redisTemplate.opsForValue().get(key);
        }
//        System.out.println(2222);
        redisTemplate.opsForValue().set(key, value);
//        List<RelationShipVO> relationShipVos = getRelationShipVo();
//        SOURCE_CACHE.put(SysUser.class, relationShipVos);
//        SOURCE_CACHE.put(SysClass.class, relationShipVos);
//        String sourceCache = JSON.toJSONString(SOURCE_CACHE, SerializerFeature.DisableCircularReferenceDetect);
//        redisTemplate.opsForValue().set(key, sourceCache);
//        redisTemplate.persist(key);
//        redisTemplate.opsForValue().get(key);
////        JSON.parseObject(redisTemplate.opsForValue().get(key), new TypeReference<Map<String, List<RelationShipVO>>>(){})
//        String json = redisTemplate.opsForValue().get(key).toString();
//        Map<String, List<RelationShipVO>> tempMap = JSON.parseObject(json, new TypeReference<Map<String, List<RelationShipVO>>>(){});
//        Map<Class, List<RelationShipVO>> resultMap = new HashMap<>();
//        for (Map.Entry<String, List<RelationShipVO>> entry : tempMap.entrySet()) {
//            try {
//                Class cls = Class.forName(entry.getKey());
//                resultMap.put(cls, entry.getValue());
//            } catch (ClassNotFoundException e) {
//                // 处理异常，类找不到
//            }
//        }
    return Result.SUCCESS;
    }

    private List<RelationShipVO> getRelationShipVo() {
        ArrayList<RelationShipVO> relationShipVOS = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            RelationShipVO relationShipVO = RelationShipVO.builder().
                    srcClass(SysClass.class)
                    .srcAttr("AAA")
                    .targetClass(SysClass.class)
                    .targetAttr("BBB")
                    .cascades(new Cascade[]{Cascade.ALL})
                    .build();
            relationShipVOS.add(relationShipVO);
        }
        return relationShipVOS;
    }

}
