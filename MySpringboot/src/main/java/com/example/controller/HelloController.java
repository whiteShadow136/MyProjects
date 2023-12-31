package com.example.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:com.example.controller
 * @Date:2023/9/15
 * @Author:谢锦创
 */
@RestController
@Data
public class HelloController {

    private String name = "aaa";
    
    @RequestMapping("/hello")
    public String hello() {
        System.out.println(1111);
        play();
        return "hello";
    }

    void play() {
        System.out.println(22222);
        System.out.println(22222);
        System.out.println(22222);
    }
}
