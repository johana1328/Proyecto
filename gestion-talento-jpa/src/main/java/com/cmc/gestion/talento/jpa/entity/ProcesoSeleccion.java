package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.gestion.talento.jpa.type.TipoEstadoSeleccion;

@Entity
@Table(name = "proceso_seleccion")
public class ProcesoSeleccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProcesoSeleccionPk procesoSeleccionPk;
	
	@JoinColumn(name = "id_candidato", nullable = false,foreignKey = @ForeignKey(name = "candidato_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Candidato candidato;
	
	@JoinColumn(name = "solicitud_personal", nullable = false,foreignKey = @ForeignKey(name = "id_solicitud_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private SolicitudDePersonal solicitudDePersonal;
	
	@Column(name = "fecha_asociacion", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaAsociacion;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "estado", nullable = false)
	private TipoEstadoSeleccion stado;

	public ProcesoSeleccionPk getProcesoSeleccionPk() {
		return procesoSeleccionPk;
	}

	public void setProcesoSeleccionPk(ProcesoSeleccionPk procesoSeleccionPk) {
		this.procesoSeleccionPk = procesoSeleccionPk;
	}

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

	public Calendar getFechaAsociacion() {
		return fechaAsociacion;
	}

	public void setFechaAsociacion(Calendar fechaAsociacion) {
		this.fechaAsociacion = fechaAsociacion;
	}

	public TipoEstadoSeleccion getStado() {
		return stado;
	}

	public void setStado(TipoEstadoSeleccion stado) {
		this.stado = stado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
