package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class EspecialidadDto {

	
	private long id;
	
	@NotEmpty(message ="Especialidad es requerida.")
	@NotBlank(message = "Especialidad es requerida.")
	@Pattern(regexp = "[A-Za-z ]*" , message = "Especialidad solo puede contener letras.")

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
