package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CompetenciaCorporativaDto {
	private long id;

	@NotEmpty(message = "Competencia corporativa no puede ser nulo")
	@NotBlank(message = "Competencia corporativa no puede ser nulo")
	
	private String nombre;
	private String descripcion;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
