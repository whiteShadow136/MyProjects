package org.example.controller;

import io.swagger.annotations.Api;
import org.example.annotation.MyAnnotationSwagger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:org.example.controller
 * @Date:2023/8/22
 * @Author:谢锦创
 */

@RestController
@Api(tags = {"MyController"}, description = "测试API类型描述信息")
public class MyController1 {
    @PostMapping("/post1")
    public String post() {
        return "post";
    }

    @GetMapping("/get1")
    public String get(String a, String b) {
        return "get";
    }

    @RequestMapping("/req1")
    @MyAnnotationSwagger
    public String req(String m) {
        return "req";
    }
}
