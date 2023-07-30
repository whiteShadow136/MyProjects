package simpleSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:simpleSecurity.controller
 * @Date:2023/7/30
 * @Author:谢锦创
 */
@Controller
public class Login {

    @RequestMapping("/login.html")
    public String login() {

        return "login";
    }
}
