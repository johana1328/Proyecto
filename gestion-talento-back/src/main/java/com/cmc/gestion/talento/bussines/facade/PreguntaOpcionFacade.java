package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.PreguntaOpcionDto;
import com.cmc.gestion.talento.bussines.dto.PruebaPreguntaDto;
import com.cmc.gestion.talento.jpa.entity.PreguntaOpcion;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class PreguntaOpcionFacade extends FacadeConvert<PreguntaOpcionDto, PreguntaOpcion> {

	@Override
	protected PreguntaOpcionDto mapper(PreguntaOpcion entidad) {
		PreguntaOpcionDto opcionDto = new PreguntaOpcionDto();
		opcionDto.setIdOpcion(entidad.getIdOpcion());
		opcionDto.setOpcion(entidad.getOpcion());
		opcionDto.setValor(entidad.getValor());
		opcionDto.setArchivoAdjuto(entidad.getArchivoAdjunto());
		if (entidad.getPruebaPregunta() != null) {
		PruebaPreguntaDto pregunta = new PruebaPreguntaDto();
		pregunta.setIdPregunta(entidad.getPruebaPregunta().getIdPregunta());
		pregunta.setEnunciado(entidad.getPruebaPregunta().getEnunciado());
		pregunta.setArchivoAdjuto(entidad.getPruebaPregunta().getArchivoAdjunto());
		opcionDto.setPreguntaDto(pregunta);
		}
		return opcionDto;
	}

}
