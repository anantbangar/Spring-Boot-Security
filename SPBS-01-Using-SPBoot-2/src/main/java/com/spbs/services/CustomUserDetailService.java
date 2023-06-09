package com.spbs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spbs.entities.CustomUserDetails;
import com.spbs.entities.User;
import com.spbs.repositories.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService 
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException 
	{
		User user=this.userRepository.findByUserName(userName);
		if(user==null)
		{
			throw new UsernameNotFoundException("No User");
		}
		
		return new CustomUserDetails(user);
	}

}
