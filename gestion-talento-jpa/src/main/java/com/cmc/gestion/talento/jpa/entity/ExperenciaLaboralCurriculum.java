package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;

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
@Table(name="experencia_laboral")
public class ExperenciaLaboralCurriculum implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "empresa", length = 100,nullable = false)
	private String empresa;
	
	@Column(name = "rol", length = 100,nullable = false)
	private String rol;
	
	@Column(name = "funciones", length = 500,nullable = false)
	private String funciones;
	
	@Column(name = "duracion", length = 100,nullable = false)
	private String duracion;
	
	@Column(name = "entorno_herramientas_tecnologias", length = 500,nullable = false)
	private String entornoHerramientasTecnologias;
	
	@JoinColumn(name = "id_usuario", nullable = false,foreignKey = @ForeignKey(name = "datosBasicos_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private DatosBasicosCurriculum datosBasicos;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getFunciones() {
		return funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getEntornoHerramientasTecnologias() {
		return entornoHerramientasTecnologias;
	}

	public void setEntornoHerramientasTecnologias(String entornoHerramientasTecnologias) {
		this.entornoHerramientasTecnologias = entornoHerramientasTecnologias;
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
