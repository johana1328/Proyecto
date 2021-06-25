package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.gestion.talento.jpa.type.TipoEstadoSolicitud;
import com.cmc.gestion.talento.jpa.type.TipoSolicitud;
@Entity
@Table(name = "solicitud", indexes = { @Index(name = "solicitud_index", columnList = "id_solicitud", unique = true) })
public class Solicitud implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_solicitud")
	private long idSolicitud;

	@JoinColumn(name = "solicitante", nullable = false,foreignKey = @ForeignKey(name = "solicitante_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Empleado Solicitante;

	@Column(name = "fecha_solicitud", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaCreacion;

	@Column(name = "fecha_actualizacion")
	@Temporal(TemporalType.DATE)
	private Calendar fechaActualizacion;

	@Column(name = "observacion_solicitante", length = 500)
	private String observacionSolicitante;

	@Column(name = "observacion_gestor", length = 500)
	private String observacionGestor;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo_solicitud", nullable = false)
	private TipoSolicitud tipoSolicitud;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "estado", nullable = false)
	private TipoEstadoSolicitud estado;

	@Column(name = "gestor", nullable = false, length = 100)
	private String gestor;

	public long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Empleado getSolicitante() {
		return Solicitante;
	}

	public void setSolicitante(Empleado solicitante) {
		Solicitante = solicitante;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Calendar getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Calendar fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getObservacionSolicitante() {
		return observacionSolicitante;
	}

	public void setObservacionSolicitante(String observacionSolicitante) {
		this.observacionSolicitante = observacionSolicitante;
	}

	public String getObservacionGestor() {
		return observacionGestor;
	}

	public void setObservacionGestor(String observacionGestor) {
		this.observacionGestor = observacionGestor;
	}

	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public TipoEstadoSolicitud getEstado() {
		return estado;
	}

	public void setEstado(TipoEstadoSolicitud estado) {
		this.estado = estado;
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

}
