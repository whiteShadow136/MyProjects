package simpleSecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:simpleSecurity.controller
 * @Date:2023/7/27
 * @Author:谢锦创
 */
@RestController
public class NoAuth {

    @RequestMapping("/index")
    public String index() {
        System.out.println(222);
        return "index";
    }

}
