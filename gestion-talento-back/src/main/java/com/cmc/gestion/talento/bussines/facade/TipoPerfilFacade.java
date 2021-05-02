package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.TipoPerfilDto;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class TipoPerfilFacade extends FacadeConvert<TipoPerfilDto, ParametriaDetalle>{
	@Override
	protected TipoPerfilDto mapper(ParametriaDetalle entidad) {
		TipoPerfilDto tipoPerfil = new TipoPerfilDto();
		tipoPerfil.setId(entidad.getId());
		tipoPerfil.setPerfil(entidad.getValor());
		return tipoPerfil;
	}
}
