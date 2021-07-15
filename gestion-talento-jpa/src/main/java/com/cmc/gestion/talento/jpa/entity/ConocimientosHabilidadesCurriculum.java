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
@Table(name="conocimientos_habilidades")
public class ConocimientosHabilidadesCurriculum  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "frontend", length = 500,nullable = false)
	private String frontEnd;
	
	@Column(name = "backend", length = 500,nullable = false)
	private String backEnd;
	
	@JoinColumn(name = "id_usuario", nullable = false,foreignKey = @ForeignKey(name = "datosBasicos_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private DatosBasicosCurriculum datosBasicos;

	public long getIdConocimientosHabili() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrontEnd() {
		return frontEnd;
	}

	public void setFrontEnd(String frontEnd) {
		this.frontEnd = frontEnd;
	}

	public String getBackEnd() {
		return backEnd;
	}

	public void setBackEnd(String backEnd) {
		this.backEnd = backEnd;
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
	

}
