package com.ms.mybatis;

import com.ms.mybatis.service.CarService;
import com.ms.mybatis.spring.MyBatisMapperBeanDefinitionRegistrar;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.io.InputStream;

/**
 * The demo to integrate mybatis with spring
 */
@Slf4j
@ComponentScan("com.ms.mybatis")
@Import(MyBatisMapperBeanDefinitionRegistrar.class)
public class MybatisApplication {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        String xmlConfigFile = "mybatis-config.xml"; // specified the config file path
        InputStream resourceAsStream = Resources.getResourceAsStream(xmlConfigFile);
        return new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MybatisApplication.class);
        applicationContext.refresh();

        CarService carService = applicationContext.getBean("carService", CarService.class);
        Car car = carService.getCar(1);
        log.info("##### car :: {}", car);
    }
}
