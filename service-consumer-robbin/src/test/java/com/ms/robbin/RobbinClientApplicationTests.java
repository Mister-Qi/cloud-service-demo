package com.ms.robbin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobbinClientApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	RedisTemplate redisTemplate;


}
