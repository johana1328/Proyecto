package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class TarifaDto {
     
	private long id;
	
	@NotEmpty(message = "Valor no puede ser nulo")
	@NotBlank(message = "Valor no puede ser nulo")
	private String valor;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}
