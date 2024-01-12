package com.ms.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class MyBatisMain {

    // the main class as an entrance of mybatis source code for a simple query demo
    // directly use of mybatis3
    public static void main3(String[] args) throws IOException {
        String xmlConfigFile = "mybatis-config.xml"; // specified the config file path

        try (InputStream resourceAsStream = Resources.getResourceAsStream(xmlConfigFile);
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        ) {
            Car car = sqlSession.selectOne("com.ms.mybatis.CarMapper.selectCarById", 1);
            log.info("car = {}", car);
            // or
            CarMapper mapper = sqlSession.getMapper(CarMapper.class);
            Car car1 = mapper.selectCarById(5);
            log.info("car1 = {}", car1);
        }


    }
    
}
