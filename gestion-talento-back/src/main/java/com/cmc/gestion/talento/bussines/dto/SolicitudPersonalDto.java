package com.cmc.gestion.talento.bussines.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.cmc.gestion.talento.jpa.type.AreaSolicitante;
import com.cmc.gestion.talento.jpa.type.EquipoComputo;
import com.cmc.gestion.talento.jpa.type.NivelEstudios;
import com.cmc.gestion.talento.jpa.type.RangoAnoExperiencia;
import com.cmc.gestion.talento.jpa.type.TipoContrato;

public class SolicitudPersonalDto extends SolicitudDto{
	private String cliente;
	private String responsableCliente;
	private String mesaTrabajo;
	private String caracteriSoftware;
	private String descripcionPerfil;
	private String salarioAsignado;
	private String cantidadVacante;
	private String horasApagar;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;
	
	private TipoContrato tipoContrato;
	private EquipoComputo equipoComputo;
	private NivelEstudios escolaridad;
	private RangoAnoExperiencia anoExperienciaMin;
	private AreaSolicitante areaSolicitante;
	
	private PerfilDto perfil;
	private EspecialidadDto especialidad;
	private ClasePerfilDto clasePerfil;
	private List<AmbientacionDto> grupoAmbientacion;
	private TarifaDto tarifa;
	
   //Datos formularios
	private long codigoPerfil;
	private long codigoEspecialidad;
	private long codClasePerfil;
	private String codTarifa;
	private List<Long> codAmbientacion;
	
	public PerfilDto getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDto perfil) {
		this.perfil = perfil;
	}
	public EspecialidadDto getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(EspecialidadDto especialidad) {
		this.especialidad = especialidad;
	}
	public ClasePerfilDto getClasePerfil() {
		return clasePerfil;
	}
	public void setClasePerfil(ClasePerfilDto clasePerfil) {
		this.clasePerfil = clasePerfil;
	}
	public List<AmbientacionDto> getGrupoAmbientacion() {
		return grupoAmbientacion;
	}
	public void setGrupoAmbientacion(List<AmbientacionDto> grupoAmbientacion) {
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
	
	public TarifaDto getTarifa() {
		return tarifa;
	}
	public void setTarifa(TarifaDto tarifa) {
		this.tarifa = tarifa;
	}
	public long getCodigoPerfil() {
		return codigoPerfil;
	}
	public void setCodigoPerfil(long codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	public long getCodigoEspecialidad() {
		return codigoEspecialidad;
	}
	public void setCodigoEspecialidad(long codigoEspecialidad) {
		this.codigoEspecialidad = codigoEspecialidad;
	}
	public long getCodClasePerfil() {
		return codClasePerfil;
	}
	public void setCodClasePerfil(long codClasePerfil) {
		this.codClasePerfil = codClasePerfil;
	}
	
	public List<Long> getCodAmbientacion() {
		return codAmbientacion;
	}
	public void setCodAmbientacion(List<Long> codAmbientacion) {
		this.codAmbientacion = codAmbientacion;
	}
	public String getCantidadVacante() {
		return cantidadVacante;
	}
	public void setCantidadVacante(String cantidadVacante) {
		this.cantidadVacante = cantidadVacante;
	}
	public String getHorasApagar() {
		return horasApagar;
	}
	public void setHorasApagar(String horasApagar) {
		this.horasApagar = horasApagar;
	}
	public String getCodTarifa() {
		return codTarifa;
	}
	public void setCodTarifa(String codTarifa) {
		this.codTarifa = codTarifa;
	}
	public String getSalarioAsignado() {
		return salarioAsignado;
	}
	public void setSalarioAsignado(String salarioAsignado) {
		this.salarioAsignado = salarioAsignado;
	}
	public AreaSolicitante getAreaSolicitante() {
		return areaSolicitante;
	}
	public void setAreaSolicitante(AreaSolicitante areaSolicitante) {
		this.areaSolicitante = areaSolicitante;
	}
	
	
	
	

}
