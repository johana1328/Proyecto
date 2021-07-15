package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cmc.gestion.talento.jpa.type.TipoHerramientaPlataformaTecnologia;

@Entity
@Table(name="competencias_tecnicas")
public class CompetenciasTecnicasCurriculum implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "entorno_herramienta_tecnolog",nullable = false)
	private TipoHerramientaPlataformaTecnologia entornoHerramientaTecnolog;
	
	@Column(name = "porcentaje", length = 100,nullable = false)
	private String porcentaje;
	
	@Column(name = "entorno_herrammienta_tecnologia",nullable = false)
	private String entornoHerrammientaTecnologia;
	
	@JoinColumn(name = "id_usuario", nullable = false,foreignKey = @ForeignKey(name = "datosBasicos_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private DatosBasicosCurriculum datosBasicos;

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	

	public String getEntornoHerrammientaTecnologia() {
		return entornoHerrammientaTecnologia;
	}

	public void setEntornoHerrammientaTecnologia(String entornoHerrammientaTecnologia) {
		this.entornoHerrammientaTecnologia = entornoHerrammientaTecnologia;
	}

	public DatosBasicosCurriculum getDatosBasicos() {
		return datosBasicos;
	}

	public void setDatosBasicos(DatosBasicosCurriculum datosBasicos) {
		this.datosBasicos = datosBasicos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoHerramientaPlataformaTecnologia getEntornoHerramientaTecnolog() {
		return entornoHerramientaTecnolog;
	}

	public void setEntornoHerramientaTecnolog(TipoHerramientaPlataformaTecnologia entornoHerramientaTecnolog) {
		this.entornoHerramientaTecnolog = entornoHerramientaTecnolog;
	}
	
}
