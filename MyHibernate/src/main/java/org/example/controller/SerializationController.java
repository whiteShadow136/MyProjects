package org.example.controller;

import ch.qos.logback.core.net.AutoFlushingObjectWriter;
import ch.qos.logback.core.net.ObjectWriter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.example.entity.MyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:org.example.controller
 * @Date:2024/1/28
 * @Author:谢锦创
 */
@RestController
public class SerializationController {

    @Autowired
    RedisTemplate redisTemplate;

    public final static Map<String, MyEntity> cache = new HashMap<>();

    @RequestMapping("/setCacheToRedis")
    public void serializationTest() throws ExecutionException, InterruptedException {
        setMapData();
        FastJsonRedisSerializer<Object> serializer = new FastJsonRedisSerializer<>(Object.class);
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.opsForValue().set("cache", cache);
        redisTemplate.persist("cache");
    }
    @RequestMapping("/setCacheToDisk")
    public void setCacheToDisk() throws IOException {
        setMapData();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D://cache"));
        objectOutputStream.writeObject(cache);
        objectOutputStream.close();
    }

    void setMapData() {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                if (!CollectionUtils.isEmpty(cache)) {
                    return 1;
                }
                for (int i = 0; i < 10; i++) {
                    MyEntity myEntity = new MyEntity();
                    myEntity.setTestName("value" + i);
                    myEntity.setId(String.valueOf(i));
                    cache.put("key" + i, myEntity);
                }
                return 1;
            }
        });
        new Thread(futureTask).start();
    }


    @RequestMapping("/getCacheByRedis")
    public void getCacheByRedis() {
        Object o = redisTemplate.opsForValue().get("cache");
        Map<String, MyEntity> myEntityMap = JSON.parseObject(o.toString(), new TypeReference<Map<String, MyEntity>>() {
        });
        System.out.println(cache);
    }

    @RequestMapping("/getCacheFromDisk")
    public void getCacheByDisk() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D://cache"));
        Map<String, MyEntity> cache = (Map<String, MyEntity>) objectInputStream.readObject();
        System.out.println(cache);
    }

    @RequestMapping("/testReflect")
    public void testReflect() throws IOException, ClassNotFoundException {

    }
}
