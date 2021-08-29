package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.SolicitudPersonalDto;
import com.cmc.gestion.talento.jpa.entity.SolicitudDePersonal;
import com.cmc.gestion.talento.web.back.FacadeConvert;

public class SolicitudPersonalFacade extends FacadeConvert<SolicitudPersonalDto,SolicitudDePersonal> {

	@Override
	protected SolicitudPersonalDto mapper(SolicitudDePersonal entidad) {
		SolicitudPersonalDto solicitudPerson = new SolicitudPersonalDto();
		
		return null;
	}

}
