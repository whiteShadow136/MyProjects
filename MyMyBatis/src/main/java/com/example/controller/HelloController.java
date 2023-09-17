package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:com.example.controller
 * @Date:2023/9/17
 * @Author:谢锦创
 */
@RestController
@RequestMapping
public class HelloController {

    @Autowired
    MyBatisDemo myBatisDemo;

    @RequestMapping("/hello")
    public String hello(String tableName, int userId) {
        myBatisDemo.userExecute(tableName, userId);
        return "hello";
    }
}
