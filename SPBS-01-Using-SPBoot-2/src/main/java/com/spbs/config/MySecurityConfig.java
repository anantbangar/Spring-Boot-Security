package com.spbs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.spbs.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
			.csrf().disable() //csrf-Cross Site Request Forgery-which secure POST/PUT methods for non browser applications
			//.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			//.and()
			.authorizeRequests()			
			//.antMatchers("/public/**").permitAll() //permiting to all role can access this url
			.antMatchers("/public/**").hasRole("NORMAL")
			.antMatchers("/users/**").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic(); //Basic Authentication
			//.formLogin();//Form based Authentication
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		
		//creating user using inMemoryAuthentication
		auth
			.inMemoryAuthentication()
			.withUser("anant")
			.password(this.passwordEncoder().encode("anant"))
			.roles("ADMIN");
		
		//creating user using inMemoryAuthentication
		auth
			.inMemoryAuthentication()
			.withUser("shailoo")
			.password(this.passwordEncoder().encode("shailoo"))
			.roles("NORMAL");
		
		
		/*
		//Authentication using Database
		auth
			.userDetailsService(customUserDetailService)
			.passwordEncoder(passwordEncoder());
		*/
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		//this is use for plain text as password
		//return NoOpPasswordEncoder.getInstance();
		
		//this is use for password encoding
		return new BCryptPasswordEncoder(10);
	}
	
	

}
