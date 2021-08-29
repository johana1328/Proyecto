package com.cmc.gestion.talento.bussines.dto;

import java.util.Date;

import com.cmc.gestion.talento.jpa.entity.Empleado;
import com.cmc.gestion.talento.jpa.type.TipoEstadoSolicitud;
import com.cmc.gestion.talento.jpa.type.TipoSolicitud;

public class SolicitudDto {
	
	private long idSolicitud;
	private Empleado solicitante;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private String observacionSolicitante;
	private String observacionGestor;
	private TipoSolicitud tipoSolicitud;
	private TipoEstadoSolicitud estado;
	private String gestor;

	public long getIdSolicitud() {
		return idSolicitud;
	}
	public Empleado getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Empleado solicitante) {
		this.solicitante = solicitante;
	}
	public void setIdSolicitud(long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
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