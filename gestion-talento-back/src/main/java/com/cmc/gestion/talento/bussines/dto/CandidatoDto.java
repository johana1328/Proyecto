package com.cmc.gestion.talento.bussines.dto;

import com.cmc.gestion.talento.jpa.type.TipoContrato;
import com.cmc.gestion.talento.jpa.type.TipoDocumento;

public class CandidatoDto {
	
	private TipoDocumento tipoDocumento;
	private String documento;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String telefono;
	private String correoElectronico;
	private String tituloProfesional;
	private String objetivos;
	private boolean trabajoActual;
	private TipoContrato tipoContrato;
	private double salarioActual;
	private String observaciones;
	private boolean horarioFlexible;
	private int disponibilidad;
	private double aspiracionSalarial;
	private String origenHoja;
	
}
