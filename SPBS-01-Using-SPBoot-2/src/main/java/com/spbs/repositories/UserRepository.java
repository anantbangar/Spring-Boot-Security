package com.spbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spbs.entities.User;

public interface UserRepository extends JpaRepository<User, String> 
{
	public User findByUserName(String UserName);
}
