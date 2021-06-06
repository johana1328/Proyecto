package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class EspecialidadDto {

	
	private long id;
	
	@NotEmpty(message ="Especialidad no puede ser nulo")
	@NotBlank(message = "El ambiente no puede ser nulo")

	private String especialidad;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
