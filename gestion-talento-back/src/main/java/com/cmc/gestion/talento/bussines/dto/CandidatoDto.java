package com.cmc.gestion.talento.bussines.dto;

import com.cmc.gestion.talento.jpa.type.TipoContrato;

public class CandidatoDto extends UsuarioDto{
	
	private String tituloProfesional;
	private String objetivos;
	private boolean trabajoActual;
	private TipoContrato tipoContrato;
	private double salarioActual;
	private String observaciones;
	private boolean horarioFlexible;
	private int disponibilidad;
	private double aspiracionSalarial;
	private String origenHoja;
	
	public String getTituloProfesional() {
		return tituloProfesional;
	}
	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}
	public String getObjetivos() {
		return objetivos;
	}
	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}
	public boolean isTrabajoActual() {
		return trabajoActual;
	}
	public void setTrabajoActual(boolean trabajoActual) {
		this.trabajoActual = trabajoActual;
	}
	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public double getSalarioActual() {
		return salarioActual;
	}
	public void setSalarioActual(double salarioActual) {
		this.salarioActual = salarioActual;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public boolean isHorarioFlexible() {
		return horarioFlexible;
	}
	public void setHorarioFlexible(boolean horarioFlexible) {
		this.horarioFlexible = horarioFlexible;
	}
	public int getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public double getAspiracionSalarial() {
		return aspiracionSalarial;
	}
	public void setAspiracionSalarial(double aspiracionSalarial) {
		this.aspiracionSalarial = aspiracionSalarial;
	}
	public String getOrigenHoja() {
		return origenHoja;
	}
	public void setOrigenHoja(String origenHoja) {
		this.origenHoja = origenHoja;
	}
	
	
}
