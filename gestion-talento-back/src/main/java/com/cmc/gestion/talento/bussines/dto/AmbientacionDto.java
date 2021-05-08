package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class AmbientacionDto {

	
	private long id;
	
	
	@NotEmpty(message = "El ambiente no puede ser nulo")
	@NotBlank(message = "El ambiente no puede ser nulo")
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
