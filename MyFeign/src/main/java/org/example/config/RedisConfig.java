package org.example.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.example.vo.RelationShipVO;
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
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // 使用FastJsonRedisSerializer来序列化和反序列化redis的value值
        FastJsonRedisSerializer<Object> serializer = new FastJsonRedisSerializer<>(Object.class);

        // 设置value的序列化规则和 key的序列化规则
        template.setValueSerializer(serializer);
        template.setKeySerializer(new StringRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }
}

