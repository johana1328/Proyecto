package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.EspecialidadDto;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class EspecialidadFacade extends FacadeConvert<EspecialidadDto, ParametriaDetalle>{

	@Override
	protected EspecialidadDto mapper(ParametriaDetalle entidad) {
		EspecialidadDto especialidad = new EspecialidadDto();
		especialidad.setId(entidad.getId());
		especialidad.setEspecialidad(entidad.getValor());
		return especialidad;
	}

	
	
	
	
	
	
	
	
	
	
	
}
