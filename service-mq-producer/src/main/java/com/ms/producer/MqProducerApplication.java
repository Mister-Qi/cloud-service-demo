package com.ms.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.netflix.eureka.config.EurekaClientConfigServerAutoConfiguration;

/**
 * The main application for mq-consumer
 */
@SpringBootApplication(exclude = {EurekaClientAutoConfiguration.class, EurekaClientConfigServerAutoConfiguration.class})
public class MqProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqProducerApplication.class);
    }
}
