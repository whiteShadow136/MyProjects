package org.example.controller;

import org.example.enums.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private final RedisTemplate redisTemplate;

    public RedisController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("save")
    public Result save(String key, String value){
        redisTemplate.opsForValue().set(key, value);
        return Result.SUCCESS;
    }

}
