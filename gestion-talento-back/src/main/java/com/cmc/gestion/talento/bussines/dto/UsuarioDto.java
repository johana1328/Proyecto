package com.cmc.gestion.talento.bussines.dto;

import java.util.Date;
import java.util.List;

import com.cmc.gestion.talento.jpa.type.TipoDocumento;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;

public class UsuarioDto {

	protected String idUsuario;
	protected String documento;
	protected TipoDocumento tipoDocumento;
	protected String primerNombre;
	protected String segundoNombre;
	protected String primerApellido;
	protected String segundoApellido;
	protected String telefono;
	protected String correoElectronico;
	protected String contrasena;
	protected TipoEstadoUsuario estado;
	protected Date fechaCreacion;
	protected Date fechaActualizacion;
	protected List<TipoPerfil> perfilUsuario;
	protected TipoPerfil perfil;
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public TipoEstadoUsuario getEstado() {
		return estado;
	}
	public void setEstado(TipoEstadoUsuario estado) {
		this.estado = estado;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public List<TipoPerfil> getPerfilUsuario() {
		return perfilUsuario;
	}
	public void setPerfilUsuario(List<TipoPerfil> perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
	public TipoPerfil getPerfil() {
		return perfil;
	}
	public void setPerfil(TipoPerfil perfil) {
		this.perfil = perfil;
	}
	

}
