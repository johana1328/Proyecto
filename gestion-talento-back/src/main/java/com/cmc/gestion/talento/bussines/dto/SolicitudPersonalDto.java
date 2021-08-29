package com.cmc.gestion.talento.bussines.dto;

import java.util.Date;
import java.util.List;

import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.jpa.type.AreaSolicitante;
import com.cmc.gestion.talento.jpa.type.EquipoComputo;
import com.cmc.gestion.talento.jpa.type.NivelEstudios;
import com.cmc.gestion.talento.jpa.type.RangoAnoExperiencia;
import com.cmc.gestion.talento.jpa.type.TipoContrato;

public class SolicitudPersonalDto extends SolicitudDto{
	
	private AreaSolicitante areaSolicitante;
	private ParametriaDetalle perfil;
	private ParametriaDetalle especialidad;
	private ParametriaDetalle clasePerfil;
	private List<ParametriaDetalle> grupoAmbientacion;
	private String descripcionPerfil;
	private TipoContrato tipoContrato;
	private Date fechaInicio;
	private EquipoComputo equipoComputo;
	private String caracteriSoftware;
	private NivelEstudios escolaridad;
	private RangoAnoExperiencia anoExperienciaMin;
	private String cliente;
	private String responsableCliente;
	private String mesaTrabajo;
	private int cantidadVacante;
	private double salarioAsignado;
	private int horasApagar;
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
	public List<ParametriaDetalle> getGrupoAmbientacion() {
		return grupoAmbientacion;
	}
	public void setGrupoAmbientacion(List<ParametriaDetalle> grupoAmbientacion) {
		this.grupoAmbientacion = grupoAmbientacion;
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
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
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
	
	


}
