package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.SolicitudPersonalDto;
import com.cmc.gestion.talento.jpa.entity.SolicitudDePersonal;
import com.cmc.gestion.talento.web.back.FacadeConvert;

public class SolicitudPersonalFacade extends FacadeConvert<SolicitudPersonalDto,SolicitudDePersonal> {

	@Override
	protected SolicitudPersonalDto mapper(SolicitudDePersonal entidad) {
		SolicitudPersonalDto solicitudPerson = new SolicitudPersonalDto();
		solicitudPerson.setAreaSolicitante(entidad.getAreaSolicitante());
		solicitudPerson.setPerfil(entidad.getPerfil());
		solicitudPerson.setEspecialidad(entidad.getEspecialidad());
		solicitudPerson.setClasePerfil(entidad.getClasePerfil());
		solicitudPerson.setGrupoAmbientacion(entidad.getGrupoAmbientacion());
		solicitudPerson.setDescripcionPerfil(entidad.getDescripcionPerfil());
		solicitudPerson.setTipoContrato(entidad.getTipoContrato());
		solicitudPerson.setFechaInicio(entidad.getFechaInicio().getTime());
		solicitudPerson.setEquipoComputo(entidad.getEquipoComputo());
		solicitudPerson.setCaracteriSoftware(entidad.getCaracteriSoftware());
		solicitudPerson.setEscolaridad(entidad.getEscolaridad());
		solicitudPerson.setAnoExperienciaMin(entidad.getAnoExperienciaMin());
		solicitudPerson.setCliente(entidad.getCliente());
		solicitudPerson.setResponsableCliente(entidad.getResponsableCliente());
		solicitudPerson.setMesaTrabajo(entidad.getMesaTrabajo());
		solicitudPerson.setCantidadVacante(entidad.getCantidadVacante());
		solicitudPerson.setSalarioAsignado(entidad.getSalarioAsignado());
		solicitudPerson.setHorasApagar(entidad.getHorasApagar());
		solicitudPerson.setTarifa(entidad.getTarifa());
		// datos solicitud
		solicitudPerson.setIdSolicitud(entidad.getIdSolicitud());
		return solicitudPerson;
	}

}
