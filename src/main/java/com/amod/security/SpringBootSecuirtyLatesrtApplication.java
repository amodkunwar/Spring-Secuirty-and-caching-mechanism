package com.amod.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.amod.security.entity.UserInfo;
import com.amod.security.repository.UserRepository;

@SpringBootApplication
public class SpringBootSecuirtyLatesrtApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecuirtyLatesrtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail("amod@gmail.com");
		userInfo.setName("Amod");
		userInfo.setPassword(passwordEncoder.encode("pwd1"));
		userInfo.setRoles("ROLE_ADMIN");

		UserInfo userInfo1 = new UserInfo();
		userInfo1.setEmail("john@gmail.com");
		userInfo1.setName("John");
		userInfo1.setPassword(passwordEncoder.encode("pwd2"));
		userInfo1.setRoles("ROLE_USER");
		userRepository.save(userInfo);

	}

}
