package org.example.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.TestEntity;
import org.example.entity.MyEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Description:org.example.config
 * @Date:2023/12/25
 * @Author:谢锦创
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> fastJsonRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // 使用FastJsonRedisSerializer来序列化和反序列化redis的value值
        FastJsonRedisSerializer<Object> serializer = new FastJsonRedisSerializer<>(Object.class);

        // 设置value的序列化规则和 key的序列化规则
        template.setValueSerializer(serializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }

//    @Bean
//    public RedisTemplate<String, MyEntity> redisTemplate1(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, MyEntity> template = new RedisTemplate<>();
////        MyEntity s = template.opsForValue().get("AAA");
//        template.setConnectionFactory(connectionFactory);
//
//        // 使用FastJsonRedisSerializer来序列化和反序列化redis的value值
//        FastJsonRedisSerializer<MyEntity> serializer = new FastJsonRedisSerializer<>(MyEntity.class);
//
//        // 设置value的序列化规则和 key的序列化规则
//        template.setValueSerializer(serializer);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(serializer);
//        template.afterPropertiesSet();
//        return template;
//    }

    @Bean
    public RedisTemplate<String, MyEntity> redisTemplate2(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, MyEntity> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Jackson2JsonRedisSerializer<TestEntity> serializer = new Jackson2JsonRedisSerializer<>(TestEntity.class);
        serializer.setObjectMapper(objectMapper);
        template.setValueSerializer(serializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }
}

