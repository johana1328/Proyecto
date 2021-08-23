package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="info_entrevista")
public class InfoEntrevista implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "token" , length = 100, nullable = false)
	private String token;
	
	@Column(name = "nombre_entrevistador", length = 100, nullable = false)
	private String entrevistador;
	
	@Id
	@Column(name = "nombre_entrevistado", length = 100, nullable = false)
	private String entrevistado;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fechaHora; 
	
	@Column(name = "duracion")
	private int duracion;
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEntrevistador() {
		return entrevistador;
	}

	public void setEntrevistador(String entrevistador) {
		this.entrevistador = entrevistador;
	}

	public String getEntrevistado() {
		return entrevistado;
	}

	public void setEntrevistado(String entrevistado) {
		this.entrevistado = entrevistado;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	

}
