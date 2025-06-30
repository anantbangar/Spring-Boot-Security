package com.spbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spbs.entities.User1;
import com.spbs.repositories.UserRepository;

@SpringBootApplication
public class Spbs02UsingSpBoot3Application implements CommandLineRunner
{
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spbs02UsingSpBoot3Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception 
	{
		User1 user1= new User1();
		user1.setUserName("anant");
		user1.setRole("ROLE_ADMIN");
		user1.setPassword(this.passwordEncoder.encode("anant"));
		this.userRepository.save(user1);
		
		User1 user2= new User1();
		user2.setUserName("shailoo");
		user2.setRole("ROLE_NORMAL");
		user2.setPassword(this.passwordEncoder.encode("shailoo"));
		this.userRepository.save(user2);
		
		User1 user3= new User1();
		user3.setUserName("gulab");
		user3.setRole("ROLE_NORMAL");
		user3.setPassword(this.passwordEncoder.encode("gulab"));
		this.userRepository.save(user3);
		
		User1 user4= new User1();
		user4.setUserName("sham");
		user4.setRole("ROLE_NORMAL");
		user4.setPassword(this.passwordEncoder.encode("sham"));
		this.userRepository.save(user4);
		
		User1 user5= new User1();
		user5.setUserName("pawan");
		user5.setRole("ROLE_ADMIN");
		user5.setPassword(this.passwordEncoder.encode("pawan"));
		this.userRepository.save(user5);
		
	}

}
