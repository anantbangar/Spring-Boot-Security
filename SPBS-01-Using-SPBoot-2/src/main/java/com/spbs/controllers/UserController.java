package com.spbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spbs.entities.User;
import com.spbs.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
//alternate way,see in MySecutiyConfig class
//@PreAuthorize("hasRole('ADMIN')")
public class UserController 
{
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user2 = userServiceImpl.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUsers = userServiceImpl.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/{userName}")
	public ResponseEntity<User> getUser(@PathVariable("userName") String userName)
	{
		User user = userServiceImpl.getUser(userName);
		return ResponseEntity.ok(user);
	}

}
