package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProcesoSeleccionPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "candidato",  length = 100)
	private String candidato;
	
	@Column(name = "id_solicitud_personal")
	private long idSolicitudPersonal;
	

	public String getCandidato() {
		return candidato;
	}

	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}

	public long getIdSolicitudPersonal() {
		return idSolicitudPersonal;
	}

	public void setIdSolicitudPersonal(long idSolicitudPersonal) {
		this.idSolicitudPersonal = idSolicitudPersonal;
	}
	
}
