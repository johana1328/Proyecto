package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SubserieDto {

	private long id;
	@NotEmpty(message = "El nombre de la subserie es requerido.")
	@NotBlank(message = "El nombre de la subserie es requerido.")
	private String nombre;
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "La descripcion solo puede contener valores alfanumericos ")
	private String descripcion;
	private String proceso;
	private String procedimiento;
	@NotEmpty(message = "Archivo gestión es requerido.")
	@NotBlank(message = "Archivo gestión es requerido.")
	private int archivoGestion;
	@NotEmpty(message = "Archivo Central es requerido.")
	@NotBlank(message = "Archivo Central es requerido.")
	private int archivoCentral;
	@NotEmpty(message = "El nombre de la subserie es requerido.")
	@NotBlank(message = "El nombre de la subserie es requerido.")
	private SerieDto serieDto;
	
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
	public String getProceso() {
		return proceso;
	}
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}
	public String getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}
	public int getArchivoGestion() {
		return archivoGestion;
	}
	public void setArchivoGestion(int archivoGestion) {
		this.archivoGestion = archivoGestion;
	}
	public int getArchivoCentral() {
		return archivoCentral;
	}
	public void setArchivoCentral(int archivoCentral) {
		this.archivoCentral = archivoCentral;
	}
	public SerieDto getSerieDto() {
		return serieDto;
	}
	public void setSerieDto(SerieDto serieDto) {
		this.serieDto = serieDto;
	}
	
	
	
}
