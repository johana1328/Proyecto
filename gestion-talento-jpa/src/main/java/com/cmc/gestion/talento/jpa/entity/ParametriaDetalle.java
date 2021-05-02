package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle;

@Entity
@Table(name = "parametria_detalle", indexes = { @Index(name = "id_parametria_index", columnList = "id", unique = true) })
public class ParametriaDetalle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "grupo", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private TipoParametriaDetalle grupo; 
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "valor", nullable = false, length = 100)
	private String valor;
	
	@Column(name = "descripcion", nullable = false, length = 200)
	private String descripcion;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public TipoParametriaDetalle getGrupo() {
		return grupo;
	}

	public void setGrupo(TipoParametriaDetalle grupo) {
		this.grupo = grupo;
	}
	


	
	
}
