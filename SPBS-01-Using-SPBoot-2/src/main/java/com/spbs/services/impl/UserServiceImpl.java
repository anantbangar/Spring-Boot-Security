package com.spbs.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spbs.entities.User;
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
	public User createUser(User user) 
	{
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		User user2 = userRepository.save(user);
		return user2;
	}

	@Override
	public List<User> getAllUsers() 
	{
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	@Override
	public User getUser(String userName) 
	{
		User user = userRepository.findByUserName(userName);
		return user;
	}

}
