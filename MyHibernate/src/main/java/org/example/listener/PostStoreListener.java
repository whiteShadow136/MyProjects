package org.example.listener;

import org.example.event.PostStoreEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description:org.example.listener
 * @Date:2024/1/30
 * @Author:谢锦创
 */
@Component
public class PostStoreListener implements ApplicationListener<PostStoreEvent> {

    @Override
    public void onApplicationEvent(PostStoreEvent event) {
        Object source = event.getSource();
        System.out.println(source);
    }
}
