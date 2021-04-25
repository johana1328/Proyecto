package com.cmc.gestion.talento.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.cmc.gestion.talento.jpa.type.TipoContrato;


@Entity
@Table(name = "candidato")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Candidato extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "titulo_profesional", nullable = false, length = 100)
	private String tituloProfesional;

	@Column(name = "trabajo_actual", nullable = false, columnDefinition = "boolean default false")
	private Boolean trabajoActual;

	@Column(name = "salario_actual", scale = 2)
	private double salarioActual;

	@Column(name = "tipo_contrato", nullable = false, length = 100)
	@Enumerated(value = EnumType.STRING)
	private TipoContrato tipoContrato;

	@Column(name = "aspiracion_salarial", scale = 2)
	private double aspiracionSalarial;

	@Column(name = "salario_flexible", nullable = false, columnDefinition = "boolean default false")
	private Boolean salarioFlexible;

	@Column(name = "disponibilidad")
	private int disponibilidad;

	@Column(name = "observaciones", length = 500)
	private String observaciones;

	@Column(name = "objetivos", length = 500)
	private String objetivos;

	public String getTituloProfesional() {
		return tituloProfesional;
	}

	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	public Boolean getTrabajoActual() {
		return trabajoActual;
	}

	public void setTrabajoActual(Boolean trabajoActual) {
		this.trabajoActual = trabajoActual;
	}

	public double getSalarioActual() {
		return salarioActual;
	}

	public void setSalarioActual(double salarioActual) {
		this.salarioActual = salarioActual;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public Boolean getSalarioFlexible() {
		return salarioFlexible;
	} 

	public void setSalarioFlexible(Boolean salarioFlexible) {
		this.salarioFlexible = salarioFlexible;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public double getAspiracionSalarial() {
		return aspiracionSalarial;
	}

	public void setAspiracionSalarial(double aspiracionSalarial) {
		this.aspiracionSalarial = aspiracionSalarial;
	}

}
