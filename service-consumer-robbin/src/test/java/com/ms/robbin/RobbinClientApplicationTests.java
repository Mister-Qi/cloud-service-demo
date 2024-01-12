package com.ms.robbin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class RobbinClientApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	RedisTemplate redisTemplate;


}
