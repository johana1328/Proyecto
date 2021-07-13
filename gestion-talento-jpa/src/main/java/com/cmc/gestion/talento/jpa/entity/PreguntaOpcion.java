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
@Table(name = "preguntaOpcion", indexes = {
		@Index(name = "preguntaOpcion_index", columnList = "id_opcion", unique = true) })
public class PreguntaOpcion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_opcion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOpcion;
	
	@Column(name = "opcion", length = 500, nullable = false)
	private String opcion;
	
	@Column(name = "valor", nullable = false)
	private String valor;

	@Column(name = "archivoAdjunto")
	private String archivoAdjunto;
	
	@JoinColumn(name = "id_pregunta", nullable = false,foreignKey = @ForeignKey(name = "pregunta_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private PruebaPregunta pruebaPregunta;

	public long getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(long idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getArchivoAdjunto() {
		return archivoAdjunto;
	}

	public void setArchivoAdjunto(String archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}

	public PruebaPregunta getPruebaPregunta() {
		return pruebaPregunta;
	}

	public void setPruebaPregunta(PruebaPregunta pruebaPregunta) {
		this.pruebaPregunta = pruebaPregunta;
	}

}
