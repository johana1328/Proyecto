package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.CompetenciaCorporativaDto;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class CompetenciaCorporativaFacade extends FacadeConvert<CompetenciaCorporativaDto, ParametriaDetalle>{
	@Override
	protected CompetenciaCorporativaDto mapper(ParametriaDetalle entidad) {
		CompetenciaCorporativaDto competenciaCorporativa = new CompetenciaCorporativaDto();
		competenciaCorporativa.setId(entidad.getId());
		competenciaCorporativa.setNombre(entidad.getNombre());
		competenciaCorporativa.setDescripcion(entidad.getDescripcion());
		return competenciaCorporativa;
	}
}
