package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.TarifaDto;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class TarifaFacade extends FacadeConvert<TarifaDto, ParametriaDetalle>{

	@Override
	protected TarifaDto mapper(ParametriaDetalle entidad) {
		TarifaDto tarifa = new TarifaDto();
		tarifa.setId(entidad.getId());
		tarifa.setValor(entidad.getValor());
		return tarifa;
	}

}
