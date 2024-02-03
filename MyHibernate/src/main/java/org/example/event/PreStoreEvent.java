package org.example.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description:org.example.event
 * @Date:2024/1/30
 * @Author:谢锦创
 */
public class PreStoreEvent extends ApplicationEvent {
    public PreStoreEvent(Object source) {
        super(source);
    }
}
