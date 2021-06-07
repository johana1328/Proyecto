package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ClasePerfilDto {
	private long id;

	@NotEmpty(message = "clasePerfil no puede ser nulo")
	@NotBlank(message = "clasePerfil no puede ser nulo")
	
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
