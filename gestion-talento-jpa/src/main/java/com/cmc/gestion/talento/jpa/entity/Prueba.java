package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.gestion.talento.jpa.type.TipoPrueba;

@Entity
@Table(name="Prueba")
public class Prueba implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_prueba")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPrueba;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
	@Column(name = "fecha_creacion", updatable = false,nullable = false )
	@Temporal(TemporalType.DATE)
	private Calendar fechaCreacion;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo_prueba")
	private TipoPrueba tipoPrueba;
	
	@Column(name = "estado", updatable = false,nullable = false)
	private boolean estado;
	
	@Column(name = "evaluador", length = 100, nullable = false)
	private String evaluador;

	public long getIdPrueba() {
		return idPrueba;
	}

	public void setIdPrueba(long idPrueba) {
		this.idPrueba = idPrueba;
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

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public TipoPrueba getTipoPrueba() {
		return tipoPrueba;
	}

	public void setTipoPrueba(TipoPrueba tipoPrueba) {
		this.tipoPrueba = tipoPrueba;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(String evaluador) {
		this.evaluador = evaluador;
	}
	

}
