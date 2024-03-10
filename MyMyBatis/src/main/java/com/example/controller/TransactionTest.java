package com.example.controller;

import com.example.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:org.example.controller
 * @Date:2024/3/10
 * @Author:谢锦创
 */
@Controller
@RequestMapping("/transacation")
public class TransactionTest {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test1")
    @ResponseBody
    @Transactional
    public String test1() {
        User user = userMapper.getUserById("user", 1);
        int age = user.getAge();
        user.setAge(age + 3);
        userMapper.updateUser(user);
        return "1111111";
    }

    @RequestMapping("/test2")
    @ResponseBody
    @Transactional
    public String test2() {
        User user = userMapper.getUserById("user", 1);
        int age = user.getAge();
        user.setAge(age + 10);
        userMapper.updateUser(user);
        return "222222";
    }
}
