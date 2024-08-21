package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description:org.example.config
 * @Date:2024/1/20
 * @Author:谢锦创
 */
@Component
public class RedisUtil {

    @Autowired(required = false)
    @Qualifier("redisTemplate2")
    RedisTemplate redisTemplate;

    private static String env;

    public String keyBuild(String key) {
        return env + ":" + key;
    }


    public void set(String key, String value) {
        String redisKey = keyBuild(key);
        redisTemplate.opsForValue().set(redisKey, value);
    }

    public Object get(String key) {
        String redisKey = keyBuild(key);
        return redisTemplate.opsForValue().get(redisKey);
    }

//    @Autowired
//    public void setEnv(@Value("${spring.profiles.active}") String env) {
//        RedisUtil.env = env;
//    }
}
