package com.spbs.services;

import java.util.List;

import com.spbs.entities.User;

public interface UserService 
{
	User createUser(User user);
	List<User> getAllUsers();
	User getUser(String userName);
	

}
