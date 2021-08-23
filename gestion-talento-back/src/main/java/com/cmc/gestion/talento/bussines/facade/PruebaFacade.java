package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.PruebaDto;
import com.cmc.gestion.talento.jpa.entity.Prueba;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class PruebaFacade extends FacadeConvert<PruebaDto, Prueba> {

	@Override
	protected PruebaDto mapper(Prueba entidad) {
		PruebaDto pruebaDto = new PruebaDto();
		pruebaDto.setIdPrueba(entidad.getIdPrueba());
		pruebaDto.setNombre(entidad.getNombre());
		pruebaDto.setDescripcion(entidad.getDescripcion());
		pruebaDto.setFechaCreacion(entidad.getFechaCreacion());
		pruebaDto.setTipoPrueba(entidad.getTipoPrueba());
		pruebaDto.setEstado(entidad.isEstado());
		pruebaDto.setEvaluador(entidad.getEvaluador());
		pruebaDto.setNumeroPregunta(entidad.getPreguntas().size());
		return pruebaDto;
	}

}
