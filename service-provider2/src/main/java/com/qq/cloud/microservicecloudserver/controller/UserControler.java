package com.qq.cloud.microservicecloudserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qq.cloud.microservicecloudserver.entity.User;
import com.qq.cloud.microservicecloudserver.reposiroty.UserRepository;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserControler {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/test")
	public String Test() {
		return "hello world";
	}

	@GetMapping("/find/{id}")
	public User queryUserById(@PathVariable Long id) {
		log.info("execute service provider2-queryUser by id..with id {}",id);
		return userRepository.findById(id).get();

	}
}
