package com.spbs.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spbs.entities.User1;
import com.spbs.repositories.UserRepository;
import com.spbs.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User1 createUser(User1 user1) 
	{
		String encodedPassword = passwordEncoder.encode(user1.getPassword());
		user1.setPassword(encodedPassword);
		
		User1 user2 = userRepository.save(user1);
		return user2;
	}

	@Override
	public List<User1> getAllUsers() 
	{
		List<User1> allUsers = userRepository.findAll();
		return allUsers;
	}

	@Override
	public User1 getUser(String userName) 
	{
		User1 user1 = userRepository.findByUserName(userName);
		return user1;
	}

}
