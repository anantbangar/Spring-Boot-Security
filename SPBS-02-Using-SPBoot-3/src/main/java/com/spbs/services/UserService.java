package com.spbs.services;

import java.util.List;

import com.spbs.entities.User1;

public interface UserService 
{
	User1 createUser(User1 user1);
	List<User1> getAllUsers();
	User1 getUser(String userName);
	

}
