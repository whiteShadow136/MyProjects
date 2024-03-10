package org.example.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.MyEntity;
import org.example.entity.MyEntityVo;
import org.example.entity.SysClass;
import org.example.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:org.example.controller
 * @Date:2024/3/9
 * @Author:谢锦创
 */
@Controller
@RequestMapping("/redistest")
public class RedisTest {

    @Autowired
    @Qualifier("fastJsonRedisTemplate")
    private RedisTemplate redisTemplate;


    @RequestMapping("/test")
    public void putAndGetObject() {
        MyEntity myEntity = MyEntity.getRandomInstance();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = (Map<String, Object>) JSON.toJSON(myEntity);
        SysClass sysClass = SysClass.getRandomInstance();
        map.put(sysClass.getClass().getName(), sysClass);
        redisTemplate.opsForHash().putAll(myEntity.getNameEn(), map);
        BoundHashOperations hashOperations = redisTemplate.boundHashOps(myEntity.getNameEn());
        hashOperations.putAll(map);
        Object o = hashOperations.get(myEntity.getNameEn());
        System.out.println(map);

        MyEntityVo myEntityVo = MyEntityVo.getRandomInstance();
        String nameEn = myEntityVo.getMyEntity().getNameEn();
        redisTemplate.opsForValue().set(nameEn, myEntityVo);
        Object o1 = redisTemplate.opsForValue().get(nameEn);
        System.out.println(myEntityVo);;
    }
}
