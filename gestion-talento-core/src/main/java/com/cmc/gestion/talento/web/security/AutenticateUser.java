package com.cmc.gestion.talento.web.security;

public interface AutenticateUser {
	
	public UserDetail autenticate(String user, String password);

}
