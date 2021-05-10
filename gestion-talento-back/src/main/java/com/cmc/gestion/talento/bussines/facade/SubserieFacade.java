package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.SerieDto;
import com.cmc.gestion.talento.bussines.dto.SubserieDto;
import com.cmc.gestion.talento.jpa.entity.SubSerie;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class SubserieFacade extends FacadeConvert<SubserieDto, SubSerie> {

	@Override
	protected SubserieDto mapper(SubSerie entidad) {
		SubserieDto subserieDto = new SubserieDto();
		subserieDto.setId(entidad.getIdSubserie());
		subserieDto.setNombre(entidad.getNombre());
		subserieDto.setDescripcion(entidad.getDescripcion());
		subserieDto.setProceso(entidad.getProceso());
		subserieDto.setProcedimiento(entidad.getProcedimiento());
		subserieDto.setArchivoGestion(entidad.getArchivoGestion());
		subserieDto.setArchivoCentral(entidad.getArchivoCentral());
		if (entidad.getSerie()!= null) {
			SerieDto serieDto = new SerieDto();
			serieDto.setId(entidad.getSerie().getIdSerie());
			serieDto.setNombre(entidad.getSerie().getNombre());
			serieDto.setDescripcion(entidad.getSerie().getDescripcion());
			serieDto.setEstado(entidad.getSerie().getEstado());	
			subserieDto.setSerieDto(serieDto);
		}
		
		return subserieDto;
	}

}
