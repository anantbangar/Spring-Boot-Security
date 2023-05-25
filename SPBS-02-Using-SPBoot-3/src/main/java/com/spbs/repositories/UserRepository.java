package com.spbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spbs.entities.User1;

public interface UserRepository extends JpaRepository<User1, String> 
{
	public User1 findByUserName(String UserName);
}
