package com.cmc.gestion.talento.bussines.dto;

import java.util.Date;

import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.jpa.entity.Solicitud;
import com.cmc.gestion.talento.jpa.type.TipoContrato;

public class SolicitudPersonalDto {
	
	private long idSolicitudPersonal;
	private Solicitud solicitud;
	private ParametriaDetalle perfil;
	private ParametriaDetalle especialidad;
	private ParametriaDetalle clasePerfil;	
	private ParametriaDetalle ambientacion;
	private String descripcionPerfil;
	private TipoContrato tipoContrato;
	private Date fechaInicio;
	private String caracteriSoftware;
	private int anoExperienciaMin ;
	private int anoExperienciaMax;
	private String cliente;
	private String responsableCliente;
	private String mesaTrabajo;
	private int cantidadVacante;
	private int horasApagar;
	private double salarioAsignado;
	private ParametriaDetalle tarifa;
	private ParametriaDetalle escolaridad;
	private ParametriaDetalle equipoComputo;
	

}
