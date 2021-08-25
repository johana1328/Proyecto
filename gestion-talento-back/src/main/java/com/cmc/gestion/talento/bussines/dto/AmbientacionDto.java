package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AmbientacionDto {

	
	private long id;
	
	
	@NotEmpty(message = "El ambiente es requerido.")
	@NotBlank(message = "El ambiente es requerido.")
	@Pattern(regexp = "[A-Za-z ]*" , message = "El ambiente solo puede contener letras.")
	private String ambiente;



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAmbiente() {
		return ambiente;
	}


	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	




	
	
	
	
	
	
	
	
	
	
}
