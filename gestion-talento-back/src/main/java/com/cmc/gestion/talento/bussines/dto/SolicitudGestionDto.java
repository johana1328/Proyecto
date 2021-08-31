package com.cmc.gestion.talento.bussines.dto;

import java.util.Date;

public class SolicitudGestionDto {

	private long idAsignacion;
	private SolicitudDto solicitud;
	private EmpleadoDto gestor;
	private Date fechaGestion;
	private Date fechaAsignacion;
	private String observacionGestor;
	
	public long getIdAsignacion() {
		return idAsignacion;
	}
	public void setIdAsignacion(long idAsignacion) {
		this.idAsignacion = idAsignacion;
	}
	public SolicitudDto getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(SolicitudDto solicitud) {
		this.solicitud = solicitud;
	}
	public EmpleadoDto getGestor() {
		return gestor;
	}
	public void setGestor(EmpleadoDto gestor) {
		this.gestor = gestor;
	}
	public Date getFechaGestion() {
		return fechaGestion;
	}
	public void setFechaGestion(Date fechaGestion) {
		this.fechaGestion = fechaGestion;
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
