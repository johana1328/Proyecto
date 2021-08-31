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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.gestion.talento.jpa.type.TipoEstadoSolicitud;
import com.cmc.gestion.talento.jpa.type.TipoSolicitud;

@Entity
@Table(name = "solicitud", indexes = { @Index(name = "solicitud_index", columnList = "id_solicitud", unique = true) })
@Inheritance(strategy = InheritanceType.JOINED)
public class Solicitud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_solicitud")
	private long idSolicitud;

	@JoinColumn(name = "solicitante", nullable = false, foreignKey = @ForeignKey(name = "solicitante_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Empleado solicitante;

	@Column(name = "fecha_solicitud", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaCreacion;

	@Column(name = "observacion_solicitante", length = 500)
	private String observacionSolicitante;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo_solicitud", nullable = false)
	private TipoSolicitud tipoSolicitud;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "estado", nullable = false)
	private TipoEstadoSolicitud estado;
	
	@OneToOne(mappedBy = "solicitud", cascade = CascadeType.ALL)
	private SolicitudGestion solicitudGestion;

	public long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Empleado getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Empleado solicitante) {
		this.solicitante = solicitante;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getObservacionSolicitante() {
		return observacionSolicitante;
	}

	public void setObservacionSolicitante(String observacionSolicitante) {
		this.observacionSolicitante = observacionSolicitante;
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

	public SolicitudGestion getSolicitudGestion() {
		return solicitudGestion;
	}

	public void setSolicitudGestion(SolicitudGestion solicitudGestion) {
		this.solicitudGestion = solicitudGestion;
	}

}
