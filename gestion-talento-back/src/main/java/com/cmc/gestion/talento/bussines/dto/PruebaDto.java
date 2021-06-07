package com.cmc.gestion.talento.bussines.dto;

import java.util.Calendar;

import javax.validation.constraints.NotEmpty;

import com.cmc.gestion.talento.jpa.type.TipoPrueba;
import com.sun.istack.NotNull;

public class PruebaDto {

	private long idPrueba;
	
	@NotNull
	@NotEmpty(message = "Nombre no puede ser nulo")
	private String nombre;
	
	private String descripcion;
	
	private Calendar fechaCreacion;
	
	private TipoPrueba tipoPrueba;
	
	private boolean estado;
	
	private String evaluador;


	public long getIdPrueba() {
		return idPrueba;
	}

	public void setIdPrueba(long idPrueba) {
		this.idPrueba = idPrueba;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public TipoPrueba getTipoPrueba() {
		return tipoPrueba;
	}

	public void setTipoPrueba(TipoPrueba tipoPrueba) {
		this.tipoPrueba = tipoPrueba;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(String evaluador) {
		this.evaluador = evaluador;
	}

}
