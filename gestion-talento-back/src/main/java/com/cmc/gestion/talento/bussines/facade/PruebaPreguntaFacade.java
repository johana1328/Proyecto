package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.PruebaPreguntaDto;
import com.cmc.gestion.talento.jpa.entity.PruebaPregunta;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class PruebaPreguntaFacade extends FacadeConvert<PruebaPreguntaDto, PruebaPregunta> {

	@Override
	protected PruebaPreguntaDto mapper(PruebaPregunta entidad) {
		PruebaPreguntaDto preguntaDto = new PruebaPreguntaDto();
		preguntaDto.setIdPregunta(entidad.getIdPregunta());
		preguntaDto.setEnunciado(entidad.getEnunciado());
		preguntaDto.setArchivoAdjuto(entidad.getArchivoAdjunto());
		return preguntaDto;
	}

}
