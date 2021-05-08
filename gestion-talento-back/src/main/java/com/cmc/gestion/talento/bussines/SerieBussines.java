package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.SerieDto;
import com.cmc.gestion.talento.bussines.facade.SerieFacade;
import com.cmc.gestion.talento.jpa.dao.SerieDao;
import com.cmc.gestion.talento.jpa.entity.Serie;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;


@Service
public class SerieBussines {
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SerieDao serieDao;
	
	@Autowired
	private SerieFacade serieFacade;
	
	public List<SerieDto> getAllSerie() {
		Iterable<Serie> listUserEntity = serieDao.findAll();
		List<SerieDto> resp = serieFacade.getListObjec(listUserEntity);
		return resp;
	}
	
	public void crearSerie(SerieDto seriedto) throws ArqGestionExcepcion{
		List<Serie> lisSerie = this.serieDao.findByNombre(seriedto.getNombre());
		if(lisSerie.isEmpty()) {
			Serie serie= new Serie();
			serie.setIdSerie(seriedto.getIdSerie());
			serie.setNombre(seriedto.getNombre());
			serie.setDescripcion(seriedto.getDescripcion());
			serie.setEstado("ACTIVO");
			this.serieDao.save(serie);
		}else {
			throw new ArqGestionExcepcion("La serie  ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	
	
	
	
	

}
