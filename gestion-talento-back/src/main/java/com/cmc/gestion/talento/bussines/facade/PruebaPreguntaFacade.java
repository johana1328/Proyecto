package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.PruebaDto;
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
		if (entidad.getPrueba() != null) {
			PruebaDto pruebaDto = new PruebaDto();
			pruebaDto.setIdPrueba(entidad.getPrueba().getIdPrueba());
			pruebaDto.setNombre(entidad.getPrueba().getNombre());
			pruebaDto.setDescripcion(entidad.getPrueba().getDescripcion());
			pruebaDto.setTipoPrueba(entidad.getPrueba().getTipoPrueba());
			pruebaDto.setFechaCreacion(entidad.getPrueba().getFechaCreacion());
			pruebaDto.setEstado(entidad.getPrueba().isEstado());
			pruebaDto.setEvaluador(entidad.getPrueba().getEvaluador());
			preguntaDto.setPruebaDto(pruebaDto);
		}
		return preguntaDto;
	}

}
