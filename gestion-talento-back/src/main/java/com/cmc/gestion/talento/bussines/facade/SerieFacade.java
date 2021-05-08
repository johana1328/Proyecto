package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.SerieDto;
import com.cmc.gestion.talento.jpa.entity.Serie;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class SerieFacade extends FacadeConvert<SerieDto,Serie> {

	@Override
	protected SerieDto mapper(Serie entidad) {
		SerieDto serieDto = new SerieDto();
		serieDto.setIdSerie(entidad.getIdSerie());
		serieDto.setNombre(entidad.getNombre());
		serieDto.setDescripcion(entidad.getDescripcion());
		return serieDto;
	}

}
