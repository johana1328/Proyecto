package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ClasePerfilDto {
	private long id;

	@NotEmpty(message = "La clase perfil es requerida.")
	@NotBlank(message = "La clase perfil es requerida.")
	@Pattern(regexp = "[A-Za-z ]*", message = "La clase perfil solo puede contener letras ")
	
	private String claseperfil;

	public String getClaseperfil() {
		return claseperfil;
	}

	public void setClaseperfil(String claseperfil) {
		this.claseperfil = claseperfil;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
		
}
