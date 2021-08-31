package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "solicitud_gestion")
public class SolicitudGestion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asignacion")
	private long idAsignacion;
	
	@JoinColumn(name = "solicitante", nullable = false, foreignKey = @ForeignKey(name = "gestor_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Solicitud solicitud;

	@JoinColumn(name = "gestor", nullable = false, foreignKey = @ForeignKey(name = "gestor_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Empleado gestor;
	
	@Column(name = "fecha_gestion")
	@Temporal(TemporalType.DATE)
	private Calendar fechaGestion;
	
	@Column(name = "fecha_asignacion")
	@Temporal(TemporalType.DATE)
	private Calendar fechaAsignacion;
	
	@Column(name = "observacion_gestor", length = 500)
	private String observacionGestor;

	public long getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(long idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Empleado getGestor() {
		return gestor;
	}

	public void setGestor(Empleado gestor) {
		this.gestor = gestor;
	}

	public Calendar getFechaGestion() {
		return fechaGestion;
	}

	public void setFechaGestion(Calendar fechaGestion) {
		this.fechaGestion = fechaGestion;
	}

	public Calendar getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Calendar fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public String getObservacionGestor() {
		return observacionGestor;
	}

	public void setObservacionGestor(String observacionGestor) {
		this.observacionGestor = observacionGestor;
	}

}
