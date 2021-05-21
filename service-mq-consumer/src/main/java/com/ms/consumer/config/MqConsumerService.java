package com.ms.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqConsumerService {

    @Autowired
    Binding binding;

    @Autowired
    Queue queue;

    @Autowired
    TopicExchange exchange;

}
