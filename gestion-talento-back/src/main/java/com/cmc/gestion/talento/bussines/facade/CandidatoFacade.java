package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.CandidatoDto;
import com.cmc.gestion.talento.jpa.entity.Candidato;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class CandidatoFacade extends FacadeConvert<CandidatoDto,Candidato> {

	@Override
	protected CandidatoDto mapper(Candidato entidad) {
		CandidatoDto candidato = new CandidatoDto();
		
		candidato.setIdUsuario(entidad.getIdUsuario());
		candidato.setTipoDocumento(entidad.getTipoDocumento());
		candidato.setDocumento(entidad.getDocumento());
		candidato.setPrimerNombre(entidad.getPrimerNombre());
		candidato.setSegundoNombre(entidad.getSegundoNombre());
		candidato.setPrimerApellido(entidad.getPrimerApellido());
		candidato.setSegundoApellido(entidad.getSegundoApellido());
		candidato.setTelefono(entidad.getTelefono());
		candidato.setCorreoElectronico(entidad.getCorreoElectronico());
		candidato.setEstado(entidad.getEstado());
		candidato.setFechaCreacion(entidad.getFechaCreacion().getTime());
		candidato.setFechaActualizacion(entidad.getFechaActualizacion().getTime());
		candidato.setPerfil(entidad.getPerfilUsuario().get(0));
		candidato.setContrasena(entidad.getContrasena());
		candidato.setTituloProfesional(entidad.getTituloProfesional());
		String trabajoActual = entidad.getTrabajoActual()?"si":"no";
		candidato.setTrabajoActual(trabajoActual);
		String salarioActual = Double.toString(entidad.getSalarioActual());
		candidato.setSalarioActual(salarioActual);
		candidato.setTipoContrato(entidad.getTipoContrato());
		candidato.setObjetivos(entidad.getObjetivos());
		candidato.setObservaciones(entidad.getObservaciones());
		candidato.setOrigenHoja(entidad.getOrigenHoja());
		String aspiracionSalarial = Double.toString(entidad.getAspiracionSalarial());
		candidato.setAspiracionSalarial(aspiracionSalarial);
		String salarioFlexible = entidad.getSalarioFlexible()?"si":"no";
		candidato.setSalarioFlexible(salarioFlexible);
		String disponibilidad = Integer.toString(entidad.getDisponibilidad());
		candidato.setDisponibilidad(disponibilidad);
		return candidato;
	
	}
	
	

}
