package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotEmpty;

public class PreguntaOpcionDto {
	
	private long idOpcion;
	@NotEmpty(message = "Opción no puede ser nulo")
	private String opcion;
	private int valor;
	private String archivoAdjuto;
	private PruebaPreguntaDto preguntaDto;
	
	public long getIdOpcion() {
		return idOpcion;
	}
	public void setIdOpcion(long idOpcion) {
		this.idOpcion = idOpcion;
	}
	public String getOpcion() {
		return opcion;
	}
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getArchivoAdjuto() {
		return archivoAdjuto;
	}
	public void setArchivoAdjuto(String archivoAdjuto) {
		this.archivoAdjuto = archivoAdjuto;
	}
	public PruebaPreguntaDto getPreguntaDto() {
		return preguntaDto;
	}
	public void setPreguntaDto(PruebaPreguntaDto preguntaDto) {
		this.preguntaDto = preguntaDto;
	}
	
	
	
}
