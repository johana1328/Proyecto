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
		SerieFacade serieFacade = new SerieFacade();
		List<SerieDto> resp = serieFacade.getListObjec(listUserEntity);
		return resp;
	}
	
	public void crearSerie(SerieDto serie) throws ArqGestionExcepcion{
		List<Serie> lisSerie = this.serieDao.findByNombre(serie.getNombre());
		if(lisSerie.isEmpty()) {
			Serie serie2= new Serie();
			serie2.setIdSerie(serie.getIdSerie());
			serie2.setNombre(serie.getNombre());
			serie2.setDescripcion(serie.getDescripcion());
			this.serieDao.save(serie2);
		}else {
			throw new ArqGestionExcepcion("La serie  ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	
	
	
	
	

}
