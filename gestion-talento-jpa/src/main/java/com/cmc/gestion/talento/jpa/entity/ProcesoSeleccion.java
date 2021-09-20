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
	
	@Column(name = "fecha_asociacion", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaAsociacion;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "estado", nullable = false)
	private TipoEstadoSeleccion estado;

	public ProcesoSeleccionPk getProcesoSeleccionPk() {
		return procesoSeleccionPk;
	}

	public void setProcesoSeleccionPk(ProcesoSeleccionPk procesoSeleccionPk) {
		this.procesoSeleccionPk = procesoSeleccionPk;
	}

	public Calendar getFechaAsociacion() {
		return fechaAsociacion;
	}

	public void setFechaAsociacion(Calendar fechaAsociacion) {
		this.fechaAsociacion = fechaAsociacion;
	}

	public TipoEstadoSeleccion getEstado() {
		return estado;
	}

	public void setEstado(TipoEstadoSeleccion estado) {
		this.estado = estado;
	}

}
