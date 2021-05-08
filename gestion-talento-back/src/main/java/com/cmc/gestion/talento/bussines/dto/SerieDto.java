package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class SerieDto {

	private long idSerie;
	@NotEmpty(message = "Nombre no puede ser nulo")
	@NotBlank(message = "Nombre no puede ser nulo")
	private String nombre;
	private String descripcion;
	
	
	public long getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(long idSerie) {
		this.idSerie = idSerie;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
