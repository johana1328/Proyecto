package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.AmbientacionDto;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class AmbientacionFacade extends FacadeConvert<AmbientacionDto, ParametriaDetalle>{
	
	@Override
	protected AmbientacionDto mapper(ParametriaDetalle entidad) {
		AmbientacionDto ambiente = new AmbientacionDto();
		ambiente.setId(entidad.getId());
		ambiente.setAmbiente(entidad.getValor());
		return ambiente;
	}

}
