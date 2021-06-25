package com.cmc.gestion.talento.bussines.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cmc.gestion.talento.jpa.type.TipoContrato;
import com.cmc.gestion.talento.jpa.type.TipoDocumento;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;

public class CandidatoDto{
	
	private String idUsuario;
	@Pattern(regexp="[0-9]+",message="Numero de documento solo numeros")  
	private String documento;
	@NotNull(message = "Campo Tipo de documento es requerido")
	private TipoDocumento tipoDocumento;
	@NotNull(message = "Campo Primer nombre es requerido")
	private String primerNombre;
	private String segundoNombre;
	@NotNull(message = "Campo Primer Apellido es requerido")
	private String primerApellido;
	private String segundoApellido;
	@Pattern(regexp="[0-9]+",message="Campo telefono solo numeros")  
	private String telefono;
	@Email(message = "Campo correo electronico invalido")  
	private String correoElectronico;
	private String contrasena;
	private TipoEstadoUsuario estado;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private List<TipoPerfil> perfilUsuario;
	private TipoPerfil perfil;
	
	private String tituloProfesional;
	private String objetivos;
	private String trabajoActual;
	private TipoContrato tipoContrato;
	private String salarioActual;
	private String observaciones;
	private String salarioFlexible;
	private String disponibilidad;
	private String aspiracionSalarial;
	private String origenHoja;
	
	public String getTituloProfesional() {
		return tituloProfesional;
	}
	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}
	public String getObjetivos() {
		return objetivos;
	}
	
	public String getTrabajoActual() {
		return trabajoActual;
	}
	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}
	public void setTrabajoActual(String trabajoActual) {
		this.trabajoActual = trabajoActual;
	}
	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getSalarioActual() {
		return salarioActual;
	}
	public void setSalarioActual(String salarioActual) {
		this.salarioActual = salarioActual;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getAspiracionSalarial() {
		return aspiracionSalarial;
	}
	public void setAspiracionSalarial(String aspiracionSalarial) {
		this.aspiracionSalarial = aspiracionSalarial;
	}
	public String getOrigenHoja() {
		return origenHoja;
	}
	public void setOrigenHoja(String origenHoja) {
		this.origenHoja = origenHoja;
	}
	
	
	public String getSalarioFlexible() {
		return salarioFlexible;
	}
	public void setSalarioFlexible(String salarioFlexible) {
		this.salarioFlexible = salarioFlexible;
	}
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
	@Override
	public String toString() {
		return "CandidatoDto [tituloProfesional=" + tituloProfesional + ", objetivos=" + objetivos + ", trabajoActual="
				+ trabajoActual + ", tipoContrato=" + tipoContrato + ", salarioActual=" + salarioActual
				+ ", observaciones=" + observaciones + ", salarioFlexible=" + salarioFlexible + ", disponibilidad="
				+ disponibilidad + ", aspiracionSalarial=" + aspiracionSalarial + ", origenHoja=" + origenHoja + "]";
	}
}
