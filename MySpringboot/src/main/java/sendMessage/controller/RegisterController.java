package sendMessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sendMessage.event.RegisterEvent;
import sendMessage.event.User;

/**
 * @Description:sendMessage
 * @Date:2023/8/9
 * @Author:谢锦创
 */
@RestController
public class RegisterController {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping("register")
    public String sendMessage(@RequestBody User user) {
        applicationEventPublisher.publishEvent(new RegisterEvent(user));
        System.out.println("请求注册");
        return "注册成功";
    }

}
