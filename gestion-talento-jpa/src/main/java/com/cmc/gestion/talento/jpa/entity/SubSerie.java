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
@Table(name = "gesdoc_subserie", indexes = { @Index(name = "indexSubserie", columnList = "id_subserie", unique = true) })
public class SubSerie implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subserie")
	private long idSubserie;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 200)
	private String descripcion;
	
	@Column(name = "proceso", length = 100)
	private String proceso;
	
	@Column(name = "procedimiento", length = 100)
	private String procedimiento;
	
	@Column(name="archivo_gestion",nullable = false)
	private int archivoGestion;
	
	@Column(name="archivo_central",nullable = false)
	private int archivoCentral;
	
	@JoinColumn(name = "id_serie", nullable = false,foreignKey = @ForeignKey(name = "serie_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Serie serie;

	public long getIdSubserie() {
		return idSubserie;
	}

	public void setIdSubserie(long idSubserie) {
		this.idSubserie = idSubserie;
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

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public int getArchivoGestion() {
		return archivoGestion;
	}

	public void setArchivoGestion(int archivoGestion) {
		this.archivoGestion = archivoGestion;
	}

	public int getArchivoCentral() {
		return archivoCentral;
	}

	public void setArchivoCentral(int archivoCentral) {
		this.archivoCentral = archivoCentral;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	

	
}
