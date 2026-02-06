package com.test.kafka.controller;

import com.test.kafka.dto.Order;
import com.test.kafka.producer.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        order.setEventType("ORDER_CREATED");
        orderProducer.sendOrderEvent(order);
        return "Order sent to Kafka";
    }
}