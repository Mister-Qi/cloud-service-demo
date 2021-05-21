package com.ms.consumer.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConsumerConfiguration {

    public static final String QUEUE="netty-queue";
    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    public static final String EXCHANGE="netty-topic-exchange";
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("");
    }

//    @Bean
//    public RabbitTemplate rabbitTemplate(){
//        RabbitTemplate rabbitTemplate = new RabbitTemplate();
//        return rabbitTemplate;
//    }

}
