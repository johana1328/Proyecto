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
@Table(name="perfil_experencia_profesional")
public class PerfilExperenciaProfesionalCurric implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "perfi_profesional", length = 500,nullable = false)
	private String perfilProfesional;
	
	@Column(name = "experencia_profesional", length = 500,nullable = false)
	private String experenciaProfesional;
	
	@JoinColumn(name = "id_usuario", nullable = false,foreignKey = @ForeignKey(name = "datosBasicos_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private DatosBasicosCurriculum datosBasicos;

	public String getPerfilProfesional() {
		return perfilProfesional;
	}

	public void setPerfilProfesional(String perfilProfesional) {
		this.perfilProfesional = perfilProfesional;
	}

	public String getExperenciaProfesional() {
		return experenciaProfesional;
	}

	public void setExperenciaProfesional(String experenciaProfesional) {
		this.experenciaProfesional = experenciaProfesional;
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
