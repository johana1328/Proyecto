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
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pruebaPregunta", indexes = {
		@Index(name = "pruebaPregunta_index", columnList = "id_pregunta", unique = true) })
public class PruebaPregunta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_pregunta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPregunta;

	@Column(name = "enunciado", length = 500, nullable = false)
	private String enunciado;

	@Column(name = "archivoAdjunto")
	private String archivoAdjunto;
	
	@JoinColumn(name = "id_prueba", nullable = false,foreignKey = @ForeignKey(name = "prueba_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Prueba prueba;

	public long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getArchivoAdjunto() {
		return archivoAdjunto;
	}

	public void setArchivoAdjunto(String archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}

	public Prueba getPrueba() {
		return prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}

}
