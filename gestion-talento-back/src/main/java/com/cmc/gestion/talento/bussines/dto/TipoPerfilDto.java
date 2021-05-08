package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class TipoPerfilDto {
	private long id;

	@NotEmpty(message = "tipoPerfil no puede ser nulo")
	@NotBlank(message = "tipoPerfil no puede ser nulo")
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
