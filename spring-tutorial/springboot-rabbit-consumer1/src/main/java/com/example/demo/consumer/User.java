package com.example.demo.consumer;

import com.example.demo.config.MessagingConfig;
import com.example.demo.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) throws InterruptedException {
        Thread.sleep(7000);
        System.out.println("Message recieved from queue : " + orderStatus);
    }
}
