package com.spbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spbs.entities.User;
import com.spbs.repositories.UserRepository;

@SpringBootApplication
public class Spbs01UsingSpBoot2Application implements CommandLineRunner
{
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spbs01UsingSpBoot2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		User user1= new User();
		user1.setUserName("anant");
		user1.setRole("ROLE_ADMIN");
		user1.setPassword(this.passwordEncoder.encode("anant"));
		this.userRepository.save(user1);
		
		User user2= new User();
		user2.setUserName("shailoo");
		user2.setRole("ROLE_NORMAL");
		user2.setPassword(this.passwordEncoder.encode("shailoo"));
		this.userRepository.save(user2);
		
		User user3= new User();
		user3.setUserName("gulab");
		user3.setRole("ROLE_NORMAL");
		user3.setPassword(this.passwordEncoder.encode("gulab"));
		this.userRepository.save(user3);
		
	}

}
