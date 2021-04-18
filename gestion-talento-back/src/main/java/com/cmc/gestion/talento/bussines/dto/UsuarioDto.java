package com.cmc.gestion.talento.bussines.dto;

import java.util.List;

import com.cmc.gestion.talento.jpa.entity.EstadoUsuario;

public class UsuarioDto {

	private String idUsuario;

	private String apellidos;

	private String area;

	private String correoElectronico;

	private EstadoUsuario estado;

	private String jefe;

	private String nombres;

	private String usuario;

	private List<PerfilDto> usPerfils;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public EstadoUsuario getEstado() {
		return estado;
	}

	public void setEstado(EstadoUsuario estado) {
		this.estado = estado;
	}

	public String getJefe() {
		return jefe;
	}

	public void setJefe(String jefe) {
		this.jefe = jefe;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<PerfilDto> getUsPerfils() {
		return usPerfils;
	}

	public void setUsPerfils(List<PerfilDto> usPerfils) {
		this.usPerfils = usPerfils;
	}

}
