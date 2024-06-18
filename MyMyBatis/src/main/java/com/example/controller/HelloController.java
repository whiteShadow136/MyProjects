package com.example.controller;

import com.example.User;
import com.example.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:com.example.controller
 * @Date:2023/9/17
 * @Author:谢锦创
 */
@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class HelloController {

    @Autowired
    MyBatisDemo myBatisDemo;

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/hello")
    public String hello(String tableName, int userId) {
        myBatisDemo.userExecute(tableName, userId);
        myBatisDemo.userExecute(tableName, userId);
        myBatisDemo.userExecute(tableName, userId);
        return "hello";
    }

    @RequestMapping("/test")
    public String test() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setName("test");
        user.setAge(18);
        userMapper.insertUser(user);
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    userService.asyncMethodA();
                    return null;
                },
                threadPoolTaskExecutor);
//
        return "test";
    }
}
