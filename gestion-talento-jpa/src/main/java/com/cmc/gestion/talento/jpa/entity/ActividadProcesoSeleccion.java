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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "actividad_proceso")
public class ActividadProcesoSeleccion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name = "id_actividad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActividad;
	
	@JoinColumns(
			{@JoinColumn(name = "candidato", nullable = false,foreignKey = @ForeignKey(name = "id_pro1_fk", value = ConstraintMode.CONSTRAINT)),
			@JoinColumn(name = "id_solicitud_personal", nullable = false,foreignKey = @ForeignKey(name = "id_pro2_fk", value = ConstraintMode.CONSTRAINT))	}
			)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ProcesoSeleccion ProcesoSeleccion;
	
	@Column(name = "calificacion",  scale = 2)
	private double calificacion;
	
	@Column(name = "fecha_asignacion", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaAsignacion;
	
	@Column(name = "fecha_realizacion", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaRealizacion;
	
	@Column(name = "id_prueba")
	private int idPrueba;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "duracion", scale = 2)
	private double duracion;
	
	
	@Column(name = "calificador", length = 100)
	private String idUsuario;


	public int getIdActividad() {
		return idActividad;
	}


	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}


	public ProcesoSeleccion getProcesoSeleccion() {
		return ProcesoSeleccion;
	}


	public void setProcesoSeleccion(ProcesoSeleccion procesoSeleccion) {
		ProcesoSeleccion = procesoSeleccion;
	}


	public double getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}


	public Calendar getFechaAsignacion() {
		return fechaAsignacion;
	}


	public void setFechaAsignacion(Calendar fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}


	public Calendar getFechaRealizacion() {
		return fechaRealizacion;
	}


	public void setFechaRealizacion(Calendar fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}


	public int getIdPrueba() {
		return idPrueba;
	}


	public void setIdPrueba(int idPrueba) {
		this.idPrueba = idPrueba;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public double getDuracion() {
		return duracion;
	}


	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}


	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
