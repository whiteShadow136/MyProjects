package org.example.listener;

import org.example.event.PreStoreEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description:org.example.listener
 * @Date:2024/1/30
 * @Author:谢锦创
 */
@Component
public class PreStoreListener implements ApplicationListener<PreStoreEvent> {

    @Override
    public void onApplicationEvent(PreStoreEvent event) {
        Object source = event.getSource();
    }
}
