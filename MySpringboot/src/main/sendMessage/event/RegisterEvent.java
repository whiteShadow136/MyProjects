package main.sendMessage.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @Description:sendMessage.listener
 * @Date:2023/8/9
 * @Author:谢锦创
 */
public class RegisterEvent extends ApplicationEvent {

    public RegisterEvent(Object source) {
        super(source);
    }

}
