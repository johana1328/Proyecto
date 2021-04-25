package com.cmc.gestion.talento.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.cmc.gestion.talento.jpa.type.TipoArea;

@Entity
@Table(name = "empleado")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Empleado extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "area",nullable = false)
	private TipoArea area;

	@Column(name = "jefe", nullable = false, length = 100)
	private String jefe;

	public TipoArea getArea() {
		return area;
	}

	public void setArea(TipoArea area) {
		this.area = area;
	}

	public String getJefe() {
		return jefe;
	}

	public void setJefe(String jefe) {
		this.jefe = jefe;
	}




}
