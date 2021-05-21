package com.ms.consumer;

import com.ms.consumer.config.MqConsumerConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * python rabbitmqadmin --host=113.142.133.87 --port 15672 --username=beidou --password=beidou@123... list exchanges
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={MqConsumerApplication.class})
//@AutoConfigureMockMvc
@Slf4j
public class RabbitTemplateTest {


    @Autowired
    RabbitTemplate rabbitTemplate;

    // 通过rabbitTemplate发送消息到指定queue
    @Test
    public void testPublish(){
        rabbitTemplate.convertAndSend(MqConsumerConfiguration.QUEUE,"hello netty demo..");
        log.info("send message to queue-{}",MqConsumerConfiguration.QUEUE);
    }


    // 从指定queue接受消息
    @Test
    public void testReceive(){
        Message receive = rabbitTemplate.receive(MqConsumerConfiguration.QUEUE);
        if(receive!=null)log.info("received message from Queue={}",receive.getBody());
        Message timedReceive = rabbitTemplate.receive(MqConsumerConfiguration.QUEUE, 5000L);
        if(timedReceive!=null)log.info("timed received message from Queue={}",timedReceive.getBody());

    }

    @Autowired
    RabbitAdmin rabbitAdmin;

    @Test
    public void testDeclareExchange(){
//        rabbitAdmin.declareBinding();

        // 声明 exchange
        rabbitAdmin.declareExchange(new TopicExchange("netty-test02-topic-exchange"));

        // 声明queue
        rabbitAdmin.declareQueue(new Queue("netty-test02-queue"));
    }
}
