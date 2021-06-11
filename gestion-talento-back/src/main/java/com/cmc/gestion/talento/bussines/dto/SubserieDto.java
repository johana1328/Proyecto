package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class SubserieDto {

	private long id;
	@NotEmpty(message = "Nombre no puede ser nulo")
	@NotBlank(message = "Nombre no puede ser nulo")
	private String nombre;
	private String descripcion;
	private String proceso;
	private String procedimiento;
	@NotEmpty(message = "Archivo gestión no puede ser nulo")
	@NotBlank(message = "Archivo gestión ser nulo")
	private int archivoGestion;
	@NotEmpty(message = "Archivo Central no puede ser nulo")
	@NotBlank(message = "Archivo Central no puede ser nulo")
	private int archivoCentral;
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
