package org.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.SysClass;
import org.example.entity.SysUser;
import org.example.entity.enums.Cascade;
import org.example.entity.enums.Result;
import org.example.vo.RelationShipVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
//    public RedisController(RedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }

    @GetMapping("save")
    public Result save(String key, String value){
        System.out.println(1111);
//        System.out.println(2222);
        redisTemplate.opsForValue().set(key, value);
        List<RelationShipVO> relationShipVos = getRelationShipVo();
        SOURCE_CACHE.put(SysUser.class, relationShipVos);
        SOURCE_CACHE.put(SysClass.class, relationShipVos);
        String sourceCache = JSON.toJSONString(SOURCE_CACHE, SerializerFeature.DisableCircularReferenceDetect);
        redisTemplate.opsForValue().set(key, sourceCache);
        redisTemplate.persist(key);
        redisTemplate.opsForValue().get(key);
//        JSON.parseObject(redisTemplate.opsForValue().get(key), new TypeReference<Map<String, List<RelationShipVO>>>(){})
        String json = redisTemplate.opsForValue().get(key).toString();
        Map<String, List<RelationShipVO>> tempMap = JSON.parseObject(json, new TypeReference<Map<String, List<RelationShipVO>>>(){});
        Map<Class, List<RelationShipVO>> resultMap = new HashMap<>();
        for (Map.Entry<String, List<RelationShipVO>> entry : tempMap.entrySet()) {
            try {
                Class cls = Class.forName(entry.getKey());
                resultMap.put(cls, entry.getValue());
            } catch (ClassNotFoundException e) {
                // 处理异常，类找不到
            }
        }
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
