package org.example.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @Description:org.example.event
 * @Date:2024/1/30
 * @Author:谢锦创
 */
public class PostStoreEvent extends ApplicationEvent {

    public PostStoreEvent(Object source) {
        super(source);
    }

    public PostStoreEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
