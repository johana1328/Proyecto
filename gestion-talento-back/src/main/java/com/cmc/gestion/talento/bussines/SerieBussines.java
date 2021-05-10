package com.cmc.gestion.talento.bussines;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	@Autowired
	EmpleadoBussines EmpleadoBussines;
	
	
	public List<SerieDto> getAllSerie(){
		EmpleadoBussines.getEmpleados();
		List<SerieDto> resp= new ArrayList<SerieDto>();
		try {
		List<Serie>	lisSerie=serieDao.findAll();
		if(!lisSerie.isEmpty()) {
			resp= serieFacade.getListObject(lisSerie);
		}
		}catch (Exception e) {
			logger.error("Error al consultar las Series " +e.getMessage());
		}
		return resp;
	}
	
	public SerieDto getSerie(long idSerie) throws ArqGestionExcepcion{
		Optional<Serie> serieOptional=serieDao.findById(idSerie);
		if(serieOptional.isPresent()) {
			SerieDto serieDto = serieFacade.getObject(serieOptional.get());
			return serieDto;
		}
		return null;
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
	
	public SerieDto actualizarSerie(SerieDto serieDto) throws ArqGestionExcepcion{
		List<Serie> listSerie= this.serieDao.findByNombre(serieDto.getNombre());
		if(listSerie.isEmpty()){
			Optional<Serie> serieOptional=this.serieDao.findById(serieDto.getIdSerie());
			if(serieOptional.isPresent()) {
				Serie serie =serieOptional.get();
				serie.setNombre(serieDto.getNombre());
				serie.setDescripcion(serieDto.getDescripcion());
				serie.setEstado(serieDto.getEstado());
				serie =this.serieDao.save(serie);
				return serieFacade.getObject(serie);
			}else {
				return null;
			}
		}else {
			throw new ArqGestionExcepcion("La serie ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	
	public void eliminarSerie(long idSerie) throws ArqGestionExcepcion{
		Optional<Serie> serieOptional=this.serieDao.findById(idSerie);
		try {
			if(serieOptional.isPresent()) {
				Serie serie =serieOptional.get();
				this.serieDao.delete(serie);
			}
		}catch (IllegalArgumentException e) {
			throw new ArqGestionExcepcion("La serie se encuentra asociada a una peticion", ExcepcionType.ERROR_VALIDATION);
		}catch (Exception e) {
			throw e;
		}
		
	}
	
	
	
	
	

}
