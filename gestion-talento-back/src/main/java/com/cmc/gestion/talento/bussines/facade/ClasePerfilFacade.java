package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.ClasePerfilDto;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class ClasePerfilFacade extends FacadeConvert<ClasePerfilDto, ParametriaDetalle>{
	@Override
	protected ClasePerfilDto mapper(ParametriaDetalle entidad) {
		ClasePerfilDto clasePerfil = new ClasePerfilDto();
		clasePerfil.setId(entidad.getId());
		clasePerfil.setClaseperfil(entidad.getValor());
		return clasePerfil;
	}
}
