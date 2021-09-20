package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProcesoSeleccionPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@JoinColumn(name = "id_candidato", nullable = false,foreignKey = @ForeignKey(name = "candidato_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Candidato candidato;
	
	@JoinColumn(name = "solicitud_personal", nullable = false,foreignKey = @ForeignKey(name = "id_solicitud_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private SolicitudDePersonal solicitudDePersonal;

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public SolicitudDePersonal getSolicitudDePersonal() {
		return solicitudDePersonal;
	}

	public void setSolicitudDePersonal(SolicitudDePersonal solicitudDePersonal) {
		this.solicitudDePersonal = solicitudDePersonal;
	}
	

	
	
}
