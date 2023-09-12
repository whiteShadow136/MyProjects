package sendMessage.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import sendMessage.event.RegisterEvent;

/**
 * @Description:sendMessage.listener
 * @Date:2023/8/9
 * @Author:谢锦创
 */
@Service
@Slf4j
public class RegisterListener implements ApplicationListener<RegisterEvent> {


    @Override
    public void onApplicationEvent(RegisterEvent event) {
        System.out.println(111);
    }
}
