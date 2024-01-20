package org.example.util;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @Description:org.example.util
 * @Date:2024/1/20
 * @Author:谢锦创
 */
@Component
public class RocketMqUtil {

    @Autowired
    private RocketMQTemplate rocketmqTemplate;

    private final static String QUEUE_NAME = "RelationShipUpdate";

    public void send(String topic, String message) {
        rocketmqTemplate.convertAndSend(topic, message);
    }

//    public static void send() throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("139.159.189.207");
//        try (Connection connection = factory.newConnection();
//             Channel channel = connection.createChannel()) {
//            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//            String message = "Data Updated!";
//            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//            System.out.println(" [x] Sent '" + message + "'");
//        }
//    }

//    public static void Receive() throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("139.159.189.207");
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//
//        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
//            System.out.println(" [x] Received '" + message + "'");
//            // 这里添加处理接收到的消息的逻辑
//        };
//        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
//    }
}
