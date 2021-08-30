package com.cmc.gestion.talento.web.security;

import java.util.List;

public class UserDetail {
	private String id;
	private String nombre;
	private List<String> perfiles;
	
	public List<String> getPerfiles() {
		return perfiles;
	}
	public void setPerfiles(List<String> perfiles) {
		this.perfiles = perfiles;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	} 

}
