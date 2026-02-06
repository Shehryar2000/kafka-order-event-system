package com.notification.kafka.consumer;

import com.notification.kafka.dto.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "order-events", groupId = "notification-group")
    public void consume(Order order) {
        System.out.println("Order received: " + order);
    }

}
