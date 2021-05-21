package com.ms.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.provider.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceProviderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceProviderApplicationTests {

	@Autowired
	private com.ms.provider.reposiroty.UserRepository UserRepository;

	@Test
	public void contextLoads() {
		Optional<User> findById = UserRepository.findById(1L);
		User user = findById.get();
		ObjectMapper mapper = new ObjectMapper();
		User user2 = user;
		try {
			String writeValueAsString = mapper.writeValueAsString(user2);
			System.out.println(writeValueAsString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(user2);
		System.out.println("**************");
	}

}
