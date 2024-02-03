package org.example.util;

/**
 * @Description:org.example.util
 * @Date:2024/1/20
 * @Author:谢锦创
 */
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyProducer {

    @Autowired(required = false)
    private RocketMQTemplate rocketMQTemplate;

    public void send(String topic, String message) {
        rocketMQTemplate.convertAndSend(topic, message);
    }
}
