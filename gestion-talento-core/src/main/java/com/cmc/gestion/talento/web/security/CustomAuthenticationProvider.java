package com.cmc.gestion.talento.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	
	@Autowired
	private AutenticateUser autenticateUser;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String password=authentication.getCredentials().toString();
		String user=authentication.getName();
		UserDetail userdetail=  autenticateUser.autenticate(user, password);
		if(userdetail != null) {
			List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			for(String  perfil: userdetail.getPerfiles()) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(perfil);
				authorities.add(authority);
			}
			  return new UsernamePasswordAuthenticationToken(
					  userdetail, password, authorities);
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
