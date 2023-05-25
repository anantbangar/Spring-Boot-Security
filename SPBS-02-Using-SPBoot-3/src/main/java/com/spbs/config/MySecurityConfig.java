package com.spbs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.spbs.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableMethodSecurity
public class MySecurityConfig
{
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		//this is use for plain text as password
		//return NoOpPasswordEncoder.getInstance();
		
		//this is use for password encoding
		return new BCryptPasswordEncoder(10);
	}
	
	/*
	@Bean
	public UserDetailsService userDetailsService()
	{
		//to use Database users for authentication plz see CustomUserDetails and CustomUserDetailService classes
	
		
		//Create users using InMemoryUserDetailsManager
		UserDetails adminUser=User
					.withUsername("anant")
					.password(passwordEncoder().encode("anant"))
					.roles("ADMIN")
					.build();
		
		UserDetails normalUser=User
					.withUsername("shailoo")
					.password(passwordEncoder().encode("shailoo"))
					.roles("NORMAL")
					.build();
		
		return new InMemoryUserDetailsManager(adminUser,normalUser);
				
	}
	*/
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity
					.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/users/**").hasRole("ADMIN")
					.requestMatchers("/public/**").hasRole("NORMAL")
					.anyRequest()
					.authenticated()
					.and()
					.httpBasic();
					//.formLogin();
		
		return httpSecurity.build();
		
	}
	
	

}
