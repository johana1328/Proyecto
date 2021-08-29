package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TarifaDto {
     
	private long id;
	@NotEmpty(message = "Tarifa es requerido.")
	@NotBlank(message = "Tarifa es requerido.")
	@NotNull(message = "Tarifa es requerido.")
	@Pattern(regexp = "^[1-9]\\d*(\\.\\d+)?$",message = "Valor solo puede contener números decimales")
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
