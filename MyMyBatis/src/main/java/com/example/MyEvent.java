package com.example;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @Description:com.example
 * @Date:2023/10/28
 * @Author:谢锦创
 */
public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
