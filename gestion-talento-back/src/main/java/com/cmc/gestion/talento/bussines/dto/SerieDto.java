package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SerieDto {
     
	private long id;
	private long idSerie;
	@NotEmpty(message = "El nombre de la serie es requerido.")
	
	@Pattern(regexp = "[A-Za-z]", message = "El nombre solo puede contener letras ")
	private String nombre;
	@Pattern(regexp = "[A-Za-z]", message = "La descripción solo puede contener letras")
	private String descripcion;
	private String estado;
	
	
	public long getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(long idSerie) {
		this.id=idSerie;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
