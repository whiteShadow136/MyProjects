package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:controller
 * @Date:2023/7/23
 * @Author:谢锦创
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello springmvc");
        return "index";//解析结果:前缀+返回值+后缀
    }
}