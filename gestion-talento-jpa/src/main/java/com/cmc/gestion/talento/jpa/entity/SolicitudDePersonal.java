package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.gestion.talento.jpa.type.TipoContrato;
@Entity
@Table(name = "solicitud_personal")
public class SolicitudDePersonal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_solicitud_personal")
	private long idSolicitudPersonal;
	
	@JoinColumn(name = "id_solicitud", nullable = false,foreignKey = @ForeignKey(name = "solicitante2_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Solicitud solicitud;
	
	@JoinColumn(name = "id_perfil", nullable = false,foreignKey = @ForeignKey(name = "perfil_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ParametriaDetalle perfil;
	
	@JoinColumn(name = "especialidad", nullable = false,foreignKey = @ForeignKey(name = "especialidad_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ParametriaDetalle especialidad;
	
	@JoinColumn(name = "clase_perfil", nullable = false,foreignKey = @ForeignKey(name = "clase_perfil_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ParametriaDetalle clasePerfil;
	
	@JoinColumn(name = "ambiente", nullable = false,foreignKey = @ForeignKey(name = "ambiente_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ParametriaDetalle ambiente;
	
	@JoinTable(
	        name = "ambientacion",
	        joinColumns = @JoinColumn(name = "solicitud_personal", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="ambinte", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.ALL)
	private List<ParametriaDetalle> ambientacion;
	
	
	
	@Column(name = "descripcion_perfil", length = 500)
	private String descripcionPerfil;
	
	@Column(name = "tipo_contrato", nullable = false, length = 100)
	@Enumerated(value = EnumType.STRING)
	private TipoContrato tipoContrato;
	
	@Column(name = "fecha_inicio_labor", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaInicio;
	
	@JoinColumn(name = "equipo_computo", nullable = false,foreignKey = @ForeignKey(name = "equipo_computo_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ParametriaDetalle equipoComputo;
	
	@Column(name = "caract_software", length = 500)
	private String caracteriSoftware;
	
	@JoinColumn(name = "escolaridad", nullable = false,foreignKey = @ForeignKey(name = "escolaridad_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ParametriaDetalle escolaridad;
	
	@Column(name = "ano_experencia_minimo",nullable = false)
	private int anoExperienciaMin;
	
	@Column(name = "ano_experencia_maximo",nullable = false)
	private int anoExperienciaMax;
	
	@Column(name = "cliente", nullable = false, length = 100)
	private String cliente;
	
	@Column(name = "responsble_cliente", nullable = false, length = 100)
	private String responsableCliente;
	
	@Column(name = "mesa_trabajo", nullable = false, length = 100)
	private String mesaTrabajo;
	
	@Column(name = "cantidad_vacante",nullable = false)
	private int cantidadVacante;
	
	@Column(name = "horas_apagar",nullable = false)
	private int horasApagar;
	
	
	@Column(name = "salario_asignado", scale = 2)
	private double salarioAsignado;
	
	@JoinColumn(name = "tarifa", nullable = false,foreignKey = @ForeignKey(name = "tarifa_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ParametriaDetalle tarifa;

	public long getIdSolicitudPersonal() {
		return idSolicitudPersonal;
	}

	public void setIdSolicitudPersonal(long idSolicitudPersonal) {
		this.idSolicitudPersonal = idSolicitudPersonal;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public ParametriaDetalle getPerfil() {
		return perfil;
	}

	public void setPerfil(ParametriaDetalle perfil) {
		this.perfil = perfil;
	}

	public ParametriaDetalle getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(ParametriaDetalle especialidad) {
		this.especialidad = especialidad;
	}

	public ParametriaDetalle getClasePerfil() {
		return clasePerfil;
	}

	public void setClasePerfil(ParametriaDetalle clasePerfil) {
		this.clasePerfil = clasePerfil;
	}

	public ParametriaDetalle getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(ParametriaDetalle ambiente) {
		this.ambiente = ambiente;
	}

	public String getDescripcionPerfil() {
		return descripcionPerfil;
	}

	public void setDescripcionPerfil(String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public ParametriaDetalle getEquipoComputo() {
		return equipoComputo;
	}

	public void setEquipoComputo(ParametriaDetalle equipoComputo) {
		this.equipoComputo = equipoComputo;
	}

	public String getCaracteriSoftware() {
		return caracteriSoftware;
	}

	public void setCaracteriSoftware(String caracteriSoftware) {
		this.caracteriSoftware = caracteriSoftware;
	}

	public ParametriaDetalle getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(ParametriaDetalle escolaridad) {
		this.escolaridad = escolaridad;
	}

	public int getAnoExperienciaMin() {
		return anoExperienciaMin;
	}

	public void setAnoExperienciaMin(int anoExperienciaMin) {
		this.anoExperienciaMin = anoExperienciaMin;
	}

	public int getAnoExperienciaMax() {
		return anoExperienciaMax;
	}

	public void setAnoExperienciaMax(int anoExperienciaMax) {
		this.anoExperienciaMax = anoExperienciaMax;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getResponsableCliente() {
		return responsableCliente;
	}

	public void setResponsableCliente(String responsableCliente) {
		this.responsableCliente = responsableCliente;
	}

	public String getMesaTrabajo() {
		return mesaTrabajo;
	}

	public void setMesaTrabajo(String mesaTrabajo) {
		this.mesaTrabajo = mesaTrabajo;
	}

	public int getCantidadVacante() {
		return cantidadVacante;
	}

	public void setCantidadVacante(int cantidadVacante) {
		this.cantidadVacante = cantidadVacante;
	}

	public int getHorasApagar() {
		return horasApagar;
	}

	public void setHorasApagar(int horasApagar) {
		this.horasApagar = horasApagar;
	}

	public double getSalarioAsignado() {
		return salarioAsignado;
	}

	public void setSalarioAsignado(double salarioAsignado) {
		this.salarioAsignado = salarioAsignado;
	}

	public ParametriaDetalle getTarifa() {
		return tarifa;
	}

	public void setTarifa(ParametriaDetalle tarifa) {
		this.tarifa = tarifa;
	}

	public List<ParametriaDetalle> getAmbientacion() {
		return ambientacion;
	}

	public void setAmbientacion(List<ParametriaDetalle> ambientacion) {
		this.ambientacion = ambientacion;
	}
		
}
