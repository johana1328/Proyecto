package com.cmc.gestion.talento.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.gestion.talento.jpa.type.AreaSolicitante;
import com.cmc.gestion.talento.jpa.type.EquipoComputo;
import com.cmc.gestion.talento.jpa.type.NivelEstudios;
import com.cmc.gestion.talento.jpa.type.RangoAnoExperiencia;
import com.cmc.gestion.talento.jpa.type.TipoContrato;
@Entity
@Table(name = "solicitud_personal")
@PrimaryKeyJoinColumn(name = "id_solicitud")
public class SolicitudDePersonal extends Solicitud{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "area_solicitante", nullable = false, length = 100)
	@Enumerated(value = EnumType.STRING)
	private AreaSolicitante areaSolicitante;
	
	
	@JoinColumn(name = "id_perfil", nullable = false,foreignKey = @ForeignKey(name = "perfil_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ParametriaDetalle perfil;
	
	@JoinColumn(name = "especialidad", nullable = false,foreignKey = @ForeignKey(name = "especialidad_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false,  fetch = FetchType.EAGER)
	private ParametriaDetalle especialidad;
	
	@JoinColumn(name = "clase_perfil", nullable = false,foreignKey = @ForeignKey(name = "clase_perfil_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ParametriaDetalle clasePerfil;
	
	
	@JoinTable(
	        name = "grupo_ambientacion",
	        joinColumns = @JoinColumn(name = "solicitud_personal", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="ambinte", nullable = false)
	    )
	@ManyToMany()
	private List<ParametriaDetalle> grupoAmbientacion;
	
	@Column(name = "descripcion_perfil", length = 500)
	private String descripcionPerfil;
	
	@Column(name = "tipo_contrato", nullable = false, length = 100)
	@Enumerated(value = EnumType.STRING)
	private TipoContrato tipoContrato;
	
	@Column(name = "fecha_inicio_labor", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaInicio;
	
	@Column(name = "equipo_computo", nullable = false, length = 100)
	@Enumerated(value = EnumType.STRING)
	private EquipoComputo equipoComputo;
	
	@Column(name = "caract_software", length = 500)
	private String caracteriSoftware;
	
	@Column(name = "escolaridad", nullable = false, length = 100)
	@Enumerated(value = EnumType.STRING)
	private NivelEstudios escolaridad;
	
	@Column(name = "ano_experencia_minima",nullable = false)
	@Enumerated(value = EnumType.STRING)
	private RangoAnoExperiencia anoExperienciaMin;
	
	@Column(name = "cliente", nullable = false, length = 100)
	private String cliente;
	
	@Column(name = "responsble_cliente", nullable = false, length = 100)
	private String responsableCliente;
	
	@Column(name = "mesa_trabajo", nullable = false, length = 100)
	private String mesaTrabajo;
	
	@Column(name = "cantidad_vacante",nullable = false)
	private int cantidadVacante;
	
	@Column(name = "salario_asignado", scale = 2)
	private double salarioAsignado;
	
	@Column(name = "horas_apagar",nullable = false)
	private int horasApagar;
	
	@JoinColumn(name = "tarifa", nullable = false,foreignKey = @ForeignKey(name = "tarifa_fk", value = ConstraintMode.CONSTRAINT))
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ParametriaDetalle tarifa;

	public AreaSolicitante getAreaSolicitante() {
		return areaSolicitante;
	}

	public void setAreaSolicitante(AreaSolicitante areaSolicitante) {
		this.areaSolicitante = areaSolicitante;
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

	public EquipoComputo getEquipoComputo() {
		return equipoComputo;
	}

	public void setEquipoComputo(EquipoComputo equipoComputo) {
		this.equipoComputo = equipoComputo;
	}

	public String getCaracteriSoftware() {
		return caracteriSoftware;
	}

	public void setCaracteriSoftware(String caracteriSoftware) {
		this.caracteriSoftware = caracteriSoftware;
	}

	public NivelEstudios getEscolaridad() {
		return escolaridad;
	}

	public void setEscolaridad(NivelEstudios escolaridad) {
		this.escolaridad = escolaridad;
	}

	public RangoAnoExperiencia getAnoExperienciaMin() {
		return anoExperienciaMin;
	}

	public void setAnoExperienciaMin(RangoAnoExperiencia anoExperienciaMin) {
		this.anoExperienciaMin = anoExperienciaMin;
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

	public double getSalarioAsignado() {
		return salarioAsignado;
	}

	public void setSalarioAsignado(double salarioAsignado) {
		this.salarioAsignado = salarioAsignado;
	}

	public int getHorasApagar() {
		return horasApagar;
	}

	public void setHorasApagar(int horasApagar) {
		this.horasApagar = horasApagar;
	}

	public ParametriaDetalle getTarifa() {
		return tarifa;
	}

	public void setTarifa(ParametriaDetalle tarifa) {
		this.tarifa = tarifa;
	}

	public List<ParametriaDetalle> getGrupoAmbientacion() {
		return grupoAmbientacion;
	}

	public void setGrupoAmbientacion(List<ParametriaDetalle> grupoAmbientacion) {
		this.grupoAmbientacion = grupoAmbientacion;
	}
		
}
