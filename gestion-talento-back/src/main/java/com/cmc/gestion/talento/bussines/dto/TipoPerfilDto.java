package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class TipoPerfilDto {
	private long id;

	@NotEmpty(message ="Tipo perfil es requerida.")
	@NotBlank(message = "Tipo perfil es requerida.")
	@Pattern(regexp = "[A-Za-z]" , message = "Tipo perfil solo puede contener letras.")
	private String perfil;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
