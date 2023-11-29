package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.annotation.MyAnnotationSwagger;
import org.example.entity.Entity;
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
public class MyController {
    @PostMapping("/post")
    public String post() {
        return "post";
    }

    @GetMapping("/get")
    @ApiOperation(value = "get方法", notes = "处理get请求")
    public String get(@ApiParam("a参数") String a,@ApiParam("b参数") String b) {
        return "get";
    }

    @RequestMapping("/req")
    @MyAnnotationSwagger
    public String req(String m) {
        return "req";
    }

    @PostMapping("/test")
    public int test(Entity entity, @ApiParam("其他信息") String otherInformation) {
        return 1;
    }
}
