package com.cmc.gestion.talento.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.cmc.gestion.talento.jpa.type.EstadoCivil;
import com.cmc.gestion.talento.jpa.type.NivelEstudios;

@Entity
@Table(name="datos_basicos")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class DatosBasicosCurriculum extends Usuario {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Column(name = "fecha_expedicion", updatable = false, nullable = false)
	private Calendar fechaExpedicion;
	
	@Column(name = "lugar_expedicion", length = 100, nullable = false)
	private String lugarExpedicion;
	
	@Column(name = "lugar_nacimiento", length = 100,nullable = false)
	private String lugarNacimiento;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	private Calendar fechaNacimiento;
	
	@Column(name = "direccion", length = 100,nullable = false)
	private String direccion;
	
	@Column(name = "barrio", length = 100)
	private String barrio;
	
	@Column(name = "localidad", length = 100)
	private String localidad;
	
	@Column(name = "estado_civil",nullable = false, length = 2)
	@Enumerated(value = EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	@Column(name = "numero_hijos")
	private long numeroHijos;
	
	@Column(name = "nivel_estudios", nullable = false, length = 2)
	@Enumerated(value = EnumType.STRING)
	private NivelEstudios nivelEstudios;
	
	@Column(name = "eps", length = 100)
	private String eps;
	
	@Column(name = "cesantias", length = 100)
	private String cesantias;
	
	@Column(name = "pensiones", length = 100)
	private String pensiones;
	
	@Column(name = "rh", length = 100,nullable = false)
	private String rh;


	public Calendar getFechaExpedicion() {
		return fechaExpedicion;
	}

	public void setFechaExpedicion(Calendar fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public String getLugarExpedicion() {
		return lugarExpedicion;
	}

	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public long getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(long numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getCesantias() {
		return cesantias;
	}

	public void setCesantias(String cesantias) {
		this.cesantias = cesantias;
	}

	public String getPensiones() {
		return pensiones;
	}

	public void setPensiones(String pensiones) {
		this.pensiones = pensiones;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}


	
	
	
	
}
