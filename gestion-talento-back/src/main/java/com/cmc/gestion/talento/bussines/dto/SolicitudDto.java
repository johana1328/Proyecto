package com.cmc.gestion.talento.bussines.dto;

import java.util.Date;

import com.cmc.gestion.talento.jpa.type.TipoEstadoSolicitud;
import com.cmc.gestion.talento.jpa.type.TipoSolicitud;

public class SolicitudDto {
	
	protected long idSolicitud;
	protected EmpleadoDto solicitante;
	protected EmpleadoDto gestor;
	protected Date fechaCreacion;
	protected Date fechaAsignacion;
	protected String observacionSolicitante;
	protected String observacionGestor;
	protected TipoSolicitud tipoSolicitud;
	protected TipoEstadoSolicitud estado;
	protected SolicitudGestionDto solicitudGestion;
	
	

	public long getIdSolicitud() {
		return idSolicitud;
	}
	
	public EmpleadoDto getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(EmpleadoDto solicitante) {
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

	public SolicitudGestionDto getSolicitudGestion() {
		return solicitudGestion;
	}

	public void setSolicitudGestion(SolicitudGestionDto solicitudGestion) {
		this.solicitudGestion = solicitudGestion;
	}

	public EmpleadoDto getGestor() {
		return gestor;
	}

	public void setGestor(EmpleadoDto gestor) {
		this.gestor = gestor;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public String getObservacionGestor() {
		return observacionGestor;
	}

	public void setObservacionGestor(String observacionGestor) {
		this.observacionGestor = observacionGestor;
	}
}
