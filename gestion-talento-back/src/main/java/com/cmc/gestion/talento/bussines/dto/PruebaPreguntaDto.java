package com.cmc.gestion.talento.bussines.dto;

import javax.validation.constraints.NotEmpty;

public class PruebaPreguntaDto {
	
	private long idPregunta;
	
	@NotEmpty(message = "Enuncido no puede ser nulo")
	private String enunciado;
	
	private String archivoAdjuto;

	public long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getArchivoAdjuto() {
		return archivoAdjuto;
	}

	public void setArchivoAdjuto(String archivoAdjuto) {
		this.archivoAdjuto = archivoAdjuto;
	}
	
	

}
