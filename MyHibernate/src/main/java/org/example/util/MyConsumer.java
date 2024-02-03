package org.example.util;

/**
 * @Description:org.example.util
 * @Date:2024/1/20
 * @Author:谢锦创
 */
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.example.relationship.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "rocketmq.consumer.topic")
@RocketMQMessageListener(
        topic = "${rocketmq.consumer.topic}",
        consumerGroup = "${rocketmq.consumer.group}",
        selectorType = SelectorType.TAG,
        selectorExpression = "*",
        consumeMode = ConsumeMode.CONCURRENTLY
)
public class MyConsumer implements RocketMQListener<String> {

    @Autowired(required = false)
    RelationShipService relationShipService;

    @Override
    public void onMessage(String message) {
        relationShipService.getCacheFromRedis();
    }
}

