package com.spbs.entities;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails 
{
	private User1 user1;
	
	public CustomUserDetails(User1 user1) 
	{		
		this.user1 = user1;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		HashSet<SimpleGrantedAuthority> authorities=new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(this.user1.getRole()));
		return authorities;
	}

	@Override
	public String getPassword() 
	{		
		return this.user1.getPassword();
	}

	@Override
	public String getUsername() 
	{		
		return this.user1.getUserName();
	}

	@Override
	public boolean isAccountNonExpired()
	{		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{		
		return true;
	}

	@Override
	public boolean isEnabled() 
	{		
		return true;
	}

}
