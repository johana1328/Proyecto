package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.SolicitudDto;
import com.cmc.gestion.talento.jpa.entity.Solicitud;
import com.cmc.gestion.talento.web.back.FacadeConvert;

public class SolicitudFacade extends FacadeConvert<SolicitudDto, Solicitud> {

	@Override
	protected SolicitudDto mapper(Solicitud entidad) {
		 SolicitudDto solicitudDto = new SolicitudDto();
		 solicitudDto.setIdSolicitud(entidad.getIdSolicitud());
		 solicitudDto.setSolicitante(entidad.getSolicitante());
		 solicitudDto.setFechaCreacion(entidad.getFechaCreacion().getTime());
		 solicitudDto.setFechaActualizacion(entidad.getFechaActualizacion().getTime());
		 solicitudDto.setObservacionGestor(entidad.getObservacionGestor());
		 solicitudDto.setObservacionSolicitante(entidad.getObservacionGestor());
		 solicitudDto.setTipoSolicitud(entidad.getTipoSolicitud());
		 solicitudDto.setEstado(entidad.getEstado());
		 solicitudDto.setGestor(entidad.getGestor());
		 
		return solicitudDto;
	}

}
