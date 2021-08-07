package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
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

@Entity
@Table(name="formacion_academica")
public class FormacionAcademica implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@Column(name = "nombre_carrera", length = 100, nullable = false)
		private String nombreCarrera;
	
	@Column(name = "lugar", length = 100, nullable = false)
		private String lugar;
	
	@Column(name = "ciudad", length = 100, nullable = false)
		private String ciudad;
	
	@Column(name = "pais", length = 100, nullable = false)
		private String pais;
	
	@Column(name = "fecha_finalizacion", updatable = false, nullable = false)
		private Calendar fechaFinalizacion;
	
	@Column(name = "certifcado",nullable = false)
		private String certifcado;
	
	@JoinColumn(name = "id_usuario", nullable = false,foreignKey = @ForeignKey(name = "datosBasicos_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private DatosBasicosCurriculum datosBasicos;

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Calendar getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Calendar fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getCertifcado() {
		return certifcado;
	}

	public void setCertifcado(String certifcado) {
		this.certifcado = certifcado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DatosBasicosCurriculum getDatosBasicos() {
		return datosBasicos;
	}

	public void setDatosBasicos(DatosBasicosCurriculum datosBasicos) {
		this.datosBasicos = datosBasicos;
	}
}
