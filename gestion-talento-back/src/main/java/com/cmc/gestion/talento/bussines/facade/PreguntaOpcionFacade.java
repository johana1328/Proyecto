package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.PreguntaOpcionDto;
import com.cmc.gestion.talento.jpa.entity.PreguntaOpcion;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class PreguntaOpcionFacade extends FacadeConvert<PreguntaOpcionDto, PreguntaOpcion> {

	@Override
	protected PreguntaOpcionDto mapper(PreguntaOpcion entidad) {
		
		return null;
	}

}
