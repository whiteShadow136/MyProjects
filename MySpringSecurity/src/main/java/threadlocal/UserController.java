package threadlocal;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:threadlocal
 * @Date:2023/7/23
 * @Author:谢锦创
 */
@Controller
@RequestMapping("user")
public class UserController {
    
    @RequestMapping(produces = "text/html",path = "hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello");
        return "<html><body>Hello, World!</body></html>";
    }
}
