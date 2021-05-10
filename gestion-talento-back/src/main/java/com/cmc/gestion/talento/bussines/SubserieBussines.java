package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.SubserieDto;
import com.cmc.gestion.talento.bussines.facade.SubserieFacade;
import com.cmc.gestion.talento.jpa.dao.SerieDao;
import com.cmc.gestion.talento.jpa.dao.SubserieDao;
import com.cmc.gestion.talento.jpa.entity.Serie;
import com.cmc.gestion.talento.jpa.entity.SubSerie;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class SubserieBussines {
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 private SubserieDao subserieDao;
	 
	 @Autowired
	 private SerieDao serieDao;
	 
	 @Autowired
	private SubserieFacade subserieFacade;
	
	@Autowired
	EmpleadoBussines EmpleadoBussines;
	
	public List<SubserieDto> getAllSubserie(){
		EmpleadoBussines.getEmpleados();
		List<SubserieDto> resp= new ArrayList<SubserieDto>();
		try {
		List<SubSerie>	lisSubserie=subserieDao.findAll();
		if(!lisSubserie.isEmpty()) {
			resp= subserieFacade.getListObject(lisSubserie);
		}
		}catch (Exception e) {
			logger.error("Error al consultar las Subseries " +e.getMessage());
		}
		return resp;
	}
	
	public SubserieDto getSubserie(long id) throws ArqGestionExcepcion{
		Optional<SubSerie> subserieOptional=subserieDao.findById(id);
		if(subserieOptional.isPresent()) {
			SubserieDto subserieDto = subserieFacade.getObject(subserieOptional.get());
			return subserieDto;
		}
		return null;
	}
	
	public void crearSubserie(SubserieDto subserieDto) throws ArqGestionExcepcion{
		List<SubSerie> lisSubserie = this.subserieDao.findAll();
		if(lisSubserie.isEmpty()) {
			SubSerie subserie = new SubSerie();
			subserie.setNombre(subserieDto.getNombre());
			subserie.setDescripcion(subserieDto.getDescripcion());
			subserie.setProceso(subserieDto.getProceso());
			subserie.setProcedimiento(subserieDto.getProcedimiento());
			subserie.setArchivoGestion(subserie.getArchivoGestion());
			subserie.setArchivoCentral(subserieDto.getArchivoCentral());
			Optional<Serie> serie = serieDao.findById(subserieDto.getSerieDto().getId());
			subserie.setSerie(serie.get());
			this.subserieDao.save(subserie);
		}else {
			throw new ArqGestionExcepcion("La Subserie  ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	public SubserieDto actualizarSubserie(SubserieDto subserieDto) throws ArqGestionExcepcion{
		List<SubSerie> listSubserie= this.subserieDao.findAll();
		if(listSubserie.isEmpty()){
			Optional<SubSerie> subserieOptional=this.subserieDao.findById(subserieDto.getId());
			if(subserieOptional.isPresent()) {
				SubSerie subserie =subserieOptional.get();
				subserie.setIdSubserie(subserieDto.getId());
				subserie.setNombre(subserieDto.getNombre());
				subserie.setDescripcion(subserieDto.getDescripcion());
				subserie.setProceso(subserieDto.getProceso());
				subserie.setProcedimiento(subserieDto.getProcedimiento());
				subserie.setArchivoGestion(subserie.getArchivoGestion());
				subserie.setArchivoCentral(subserieDto.getArchivoCentral());
				Optional<Serie> serie = serieDao.findById(subserieDto.getSerieDto().getId());
				subserie.setSerie(serie.get());
				subserie =this.subserieDao.save(subserie);
				return subserieFacade.getObject(subserie);
			}else {
				return null;
			}
		}else {
			throw new ArqGestionExcepcion("La Subserie ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	
	public void eliminarSubserie(long id) throws ArqGestionExcepcion{
		Optional<SubSerie> subserieOptional=this.subserieDao.findById(id);
		try {
			if(subserieOptional.isPresent()) {
				SubSerie subserie =subserieOptional.get();
				this.subserieDao.delete(subserie);
			}
		}catch (IllegalArgumentException e) {
			throw new ArqGestionExcepcion("La subserie se encuentra asociada a una peticion", ExcepcionType.ERROR_VALIDATION);
		}catch (Exception e) {
			throw e;
		}
		
	}

}
