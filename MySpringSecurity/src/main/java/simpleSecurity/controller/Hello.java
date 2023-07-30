package simpleSecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:simpleSecurity.controller
 * @Date:2023/7/26
 * @Author:谢锦创
 */
@RestController
public class Hello {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("你好");
        return "hello";
    }
}
