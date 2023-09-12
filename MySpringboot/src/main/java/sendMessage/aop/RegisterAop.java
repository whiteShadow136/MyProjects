package sendMessage.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * @Description:sendMessage.aop
 * @Date:2023/8/10
 * @Author:谢锦创
 */
@Aspect
@Service
public class RegisterAop {

    @Pointcut("execution(* sendMessage.controller.RegisterController.*(..))")
    public void service() {
    }
    
    @Before("service()")
    public void sendMessage() {
        System.out.println("发送短信");
    }
    
}
