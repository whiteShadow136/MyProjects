package main.sendMessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description:sendMessage
 * @Date:2023/8/9
 * @Author:谢锦创
 */
@SpringBootApplication
//@EnableAspectJAutoProxy
public class RegisterMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(RegisterMain.class);
    }
}
