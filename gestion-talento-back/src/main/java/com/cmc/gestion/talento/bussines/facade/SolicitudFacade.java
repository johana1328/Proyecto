package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.bussines.dto.SolicitudDto;
import com.cmc.gestion.talento.bussines.dto.SolicitudGestionDto;
import com.cmc.gestion.talento.jpa.entity.Solicitud;
import com.cmc.gestion.talento.jpa.entity.SolicitudGestion;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class SolicitudFacade extends FacadeConvert<SolicitudDto, Solicitud> {

	@Override
	protected SolicitudDto mapper(Solicitud entidad) {
		 SolicitudDto solicitudDto = new SolicitudDto();
		 solicitudDto.setIdSolicitud(entidad.getIdSolicitud());
		 EmpleadoDto solicitante = new EmpleadoDto();
		 solicitante.setIdUsuario(entidad.getSolicitante().getIdUsuario());
		 solicitante.setPrimerNombre(entidad.getSolicitante().getPrimerNombre());
		 solicitante.setPrimerApellido(entidad.getSolicitante().getPrimerApellido());
		 solicitudDto.setSolicitante(solicitante);
		 solicitudDto.setFechaCreacion(entidad.getFechaCreacion().getTime());
		 solicitudDto.setObservacionSolicitante(entidad.getObservacionSolicitante());
		 solicitudDto.setTipoSolicitud(entidad.getTipoSolicitud());
		 solicitudDto.setEstado(entidad.getEstado());
		 if(entidad.getSolicitudGestion()!= null) {
			 SolicitudGestionDto solicitudGestion = new SolicitudGestionDto();
			 SolicitudGestion sge=entidad.getSolicitudGestion();
			 solicitudGestion.setIdAsignacion(sge.getIdAsignacion());
			 solicitudGestion.setFechaAsignacion(sge.getFechaAsignacion().getTime());
			 solicitudGestion.setFechaGestion(sge.getFechaGestion().getTime());
			 solicitudGestion.setObservacionGestor(sge.getObservacionGestor());
			 EmpleadoDto gestor = new EmpleadoDto();
			 gestor.setIdUsuario(sge.getGestor().getIdUsuario());
			 gestor.setPrimerNombre(sge.getGestor().getPrimerNombre());
			 gestor.setPrimerApellido(sge.getGestor().getPrimerApellido());
			 solicitudGestion.setGestor(gestor);
		 }	
        return solicitudDto;
	}

}
