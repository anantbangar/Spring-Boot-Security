package com.spbs.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
//alternate way,see in MySecutiyConfig class
//@PreAuthorize("hasRole('NORMAL')")
public class HomeController 
{
	@GetMapping("/home")
	public String home()
	{
		return "This is Home page...";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "This is Login page...";
	}
	@GetMapping("/register")
	public String register()
	{
		return "This is Register page...";
	}

}
