package com.cmc.gestion.talento.bussines;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.PruebaPreguntaDto;
import com.cmc.gestion.talento.bussines.facade.PruebaPreguntaFacade;
import com.cmc.gestion.talento.jpa.dao.PruebaPreguntaDao;
import com.cmc.gestion.talento.jpa.entity.PruebaPregunta;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class PruebaPreguntaBussines {
	
	private static final Logger logger = LogManager.getLogger(PruebaPreguntaBussines.class);
	@Autowired
	private PruebaPreguntaDao pruebaPreguntaDao;
	
	@Autowired
	private PruebaPreguntaFacade pruebaPreguntaFacade;
	
	
	public List<PruebaPreguntaDto> getallPregunta(){
		Iterable<PruebaPregunta> lisPregunEntity = pruebaPreguntaDao.findAll();
		PruebaPreguntaFacade pruebaPreguntaFacade = new PruebaPreguntaFacade();
		List<PruebaPreguntaDto> resp = pruebaPreguntaFacade.getListObjec(lisPregunEntity);
		return resp;
	}
	
	public  List<PruebaPreguntaDto>  getListPreguntaPrueba(long idPregunta) {
		return null;
	}
	
	public PruebaPreguntaDto getPregunta(long idPregunta) {
		Optional<PruebaPregunta> optionPregunt = this.pruebaPreguntaDao.findById(idPregunta);
		if (optionPregunt.isPresent()) {
			PruebaPreguntaDto pruebaPreguntaDto = pruebaPreguntaFacade.getObject(optionPregunt.get());
			return pruebaPreguntaDto;
	     }
		return null;
     }
	
	public void crearPregunta(PruebaPreguntaDto pruebaPreguntaDto) throws ArqGestionExcepcion {
		List<PruebaPregunta> lisPregu = pruebaPreguntaDao.findByEnunciado(pruebaPreguntaDto.getEnunciado());
		
		if (lisPregu.isEmpty()) {
			PruebaPregunta preguntaEntity = new PruebaPregunta();
			
			preguntaEntity.setEnunciado(pruebaPreguntaDto.getEnunciado());
			preguntaEntity.setArchivoAdjunto(pruebaPreguntaDto.getArchivoAdjuto());
			
			
			this.pruebaPreguntaDao.save(preguntaEntity);
			
		}else {
			logger.error("Error al momento de crear la prueba : el enunciado ya existe");
			throw new ArqGestionExcepcion("La pregunta ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
		
	}
	
	public PruebaPreguntaDto actualizarPregunta(PruebaPreguntaDto pruebaPreguntaDto) throws ArqGestionExcepcion {
		List<PruebaPregunta> lisPregu = pruebaPreguntaDao.findByEnunciado(pruebaPreguntaDto.getEnunciado());
		
		if (lisPregu.isEmpty()) {
			Optional<PruebaPregunta> optionalPregun = this.pruebaPreguntaDao.findById(pruebaPreguntaDto.getIdPregunta());
			if (optionalPregun.isPresent()) {
				PruebaPregunta pregunta = optionalPregun.get();
				
				 pregunta.setEnunciado(pruebaPreguntaDto.getEnunciado());
				 pregunta.setArchivoAdjunto(pruebaPreguntaDto.getArchivoAdjuto());
				 this.pruebaPreguntaDao.save(pregunta);
				 return pruebaPreguntaFacade.getObject(pregunta);
				
			}else {
				return null;
			}
		}else {
			logger.error("Error al momento de modificar la pregunta : el nombre ya existe");
			throw new ArqGestionExcepcion("La pregunta ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
		
	}
	
	public void eliminarPregunta(long idPregunta) throws ArqGestionExcepcion {
		Optional<PruebaPregunta> optionalPregun = this.pruebaPreguntaDao.findById(idPregunta);
		try {
			if (optionalPregun.isPresent()) {
				PruebaPregunta pregunta = optionalPregun.get();
				this.pruebaPreguntaDao.delete(pregunta);
				
			}
		} catch (IllegalArgumentException e) {
			logger.error("Error al momento de eliminar la pregunta : la pregunta se encuentra asociada a un elemento");
			throw new ArqGestionExcepcion("La pregunta se encuentra asociada a una peticion", ExcepcionType.ERROR_VALIDATION);
		}catch (Exception e) {
			throw new ArqGestionExcepcion("Error al momento de eliminar la pregunta", ExcepcionType.ERROR_VALIDATION);
		}
		}
		
		
		
	}



	


