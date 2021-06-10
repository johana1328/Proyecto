package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.gestion.talento.jpa.type.TipoDocumento;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;

@Entity
@Table(name = "usuario", indexes = { @Index(name = "candidato_index", columnList = "documento", unique = true) })
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_usuario", nullable = false, length = 100)
	private String idUsuario;

	@Column(name = "documento", nullable = false, length = 100)
	private String documento;

	@Column(name = "tipo_documento", nullable = false, length = 2)
	@Enumerated(value = EnumType.STRING)
	private TipoDocumento tipoDocumento;

	@Column(name = "primer_nombre", nullable = false, length = 100)
	private String primerNombre;

	@Column(name = "segundo_nombre", length = 100)
	private String segundoNombre;

	@Column(name = "primer_apellido", nullable = false, length = 100)
	private String primerApellido;

	@Column(name = "segundo_apellido", length = 100)
	private String segundoApellido;

	@Column(name = "telefono", nullable = false, length = 100)
	private String telefono;

	@Column(name = "correo_electronico", nullable = false, length = 100)
	private String correoElectronico;

	@Column(name = "contrasena", length = 100)
	private String contrasena;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "estado")
	private TipoEstadoUsuario estado;

	@Column(name = "fecha_creacion", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaCreacion;

	@Column(name = "fecha_actualizacion")
	@Temporal(TemporalType.DATE)
	private Calendar fechaActualizacion;
	
	@ElementCollection(targetClass  = TipoPerfil.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "perfil_usuario",joinColumns = @JoinColumn(name = "id_usuario"))
	@Column(name = "perfil", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<TipoPerfil> perfilUsuario;

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

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Calendar getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Calendar fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public List<TipoPerfil> getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(List<TipoPerfil> perfilUsuario) {
		if(this.perfilUsuario == null) {
			this.perfilUsuario= perfilUsuario;
		}else {
			this.perfilUsuario.clear();
			this.perfilUsuario.addAll(perfilUsuario);
		}
	}

}
