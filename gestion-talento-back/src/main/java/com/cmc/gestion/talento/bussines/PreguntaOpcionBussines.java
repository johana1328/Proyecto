package com.cmc.gestion.talento.bussines;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.PreguntaOpcionDto;
import com.cmc.gestion.talento.bussines.facade.PreguntaOpcionFacade;
import com.cmc.gestion.talento.jpa.dao.PreguntaOpcionDao;
import com.cmc.gestion.talento.jpa.dao.PruebaPreguntaDao;
import com.cmc.gestion.talento.jpa.entity.PreguntaOpcion;
import com.cmc.gestion.talento.jpa.entity.PruebaPregunta;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class PreguntaOpcionBussines {
	
	private static final Logger logger = LogManager.getLogger(PreguntaOpcionBussines.class);
	
	@Autowired
	private PreguntaOpcionDao preguntaOpcionDao;
	
	@Autowired
	private PruebaPreguntaDao pruebaPreguntaDao;
	
	@Autowired
	private PreguntaOpcionFacade preguntaOpcionFacade;
	
	public List<PreguntaOpcionDto> getallopcion(){
		Iterable<PreguntaOpcion> lisOpcionEntity = preguntaOpcionDao.findAll();
		PreguntaOpcionFacade opcionFacade = new PreguntaOpcionFacade();
		List<PreguntaOpcionDto> resp = opcionFacade.getListObjec(lisOpcionEntity);
		
		return resp;
	}

	public PreguntaOpcionDto getOpcion(long idOpcion) {
		Optional<PreguntaOpcion> optionOpcion = this.preguntaOpcionDao.findById(idOpcion);
		if (optionOpcion.isPresent()) {
			PreguntaOpcionDto preguntaOpcionDto = preguntaOpcionFacade.getObject(optionOpcion.get());
			return preguntaOpcionDto;
	     }
		return null;
     }
	public List<PreguntaOpcionDto> getOpcionByPregunta(long idOpcion){
		PruebaPregunta pregunta = new PruebaPregunta();
		pregunta.setIdPregunta(idOpcion);
		
		List<PreguntaOpcion> listOpcion =  preguntaOpcionDao.findByPruebaPregunta(pregunta);
		if (!listOpcion.isEmpty()) {
			return preguntaOpcionFacade.getListObjec(listOpcion);
		}
		return null;
		
	}
	
	public void crearOpcion(PreguntaOpcionDto preguntaOpcionDto, long preguntaId) throws ArqGestionExcepcion {
		List<PreguntaOpcion> lisPregu = preguntaOpcionDao.findByOpcion(preguntaOpcionDto.getOpcion());
		Optional<PruebaPregunta> pregunta= pruebaPreguntaDao.findById(preguntaId);
		if(lisPregu.isEmpty()) {
			PreguntaOpcion opcionEntity = new PreguntaOpcion();
			opcionEntity.setPruebaPregunta(pregunta.get());
			opcionEntity.setOpcion(preguntaOpcionDto.getOpcion());
			opcionEntity.setValor(preguntaOpcionDto.getValor());
			opcionEntity.setArchivoAdjunto(preguntaOpcionDto.getArchivoAdjuto());
			this.preguntaOpcionDao.save(opcionEntity);
		}else {
			logger.error("Error al momento de crear la prueba : la opción ya existe");
			throw new ArqGestionExcepcion("La opción ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}

		
	}
	
	public PreguntaOpcionDto actualizarOpcion(PreguntaOpcionDto preguntaOpcionDto) throws ArqGestionExcepcion {
		List<PreguntaOpcion> lisPregu = preguntaOpcionDao.findByOpcion(preguntaOpcionDto.getOpcion());
		if (lisPregu.isEmpty()) {
			Optional<PreguntaOpcion> optionalOpcion = this.preguntaOpcionDao.findById(preguntaOpcionDto.getIdOpcion());
			if (optionalOpcion.isPresent()) {
				PreguntaOpcion opcionEntity = optionalOpcion.get();
				opcionEntity.setOpcion(preguntaOpcionDto.getOpcion());
				opcionEntity.setValor(preguntaOpcionDto.getValor());
				opcionEntity.setArchivoAdjunto(preguntaOpcionDto.getArchivoAdjuto());
				this.preguntaOpcionDao.save(opcionEntity);
				return preguntaOpcionFacade.getObject(opcionEntity);
			}else {
				return null;
			}
			}else {
				logger.error("Error al momento de modificar la opcion : el enunciado ya existe");
				throw new ArqGestionExcepcion("La opcion ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);

		}
	}
	
	public void eliminarOpcion(long idOpcion) throws ArqGestionExcepcion {
		Optional<PreguntaOpcion> optionalOpcion = this.preguntaOpcionDao.findById(idOpcion);
		try {
			if (optionalOpcion.isPresent()) {
				PreguntaOpcion opcionEntity = optionalOpcion.get();
				this.preguntaOpcionDao.delete(opcionEntity);
			}
		} catch (IllegalArgumentException e) {
			logger.error("Error al momento de eliminar la opción : la opción se encuentra asociada a un elemento");
			throw new ArqGestionExcepcion("La opción se encuentra asociada a una peticion", ExcepcionType.ERROR_VALIDATION);
		}catch (Exception e) {
			throw new ArqGestionExcepcion("Error al momento de eliminar la opción", ExcepcionType.ERROR_VALIDATION);
		}
	}

}
