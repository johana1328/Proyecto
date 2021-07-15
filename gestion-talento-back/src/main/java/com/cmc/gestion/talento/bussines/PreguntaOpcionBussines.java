package com.cmc.gestion.talento.bussines;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmc.gestion.talento.bussines.dto.PreguntaOpcionDto;
import com.cmc.gestion.talento.bussines.facade.PreguntaOpcionFacade;
import com.cmc.gestion.talento.jpa.dao.PreguntaOpcionDao;
import com.cmc.gestion.talento.jpa.entity.PreguntaOpcion;
import com.cmc.gestion.talento.jpa.entity.PruebaPregunta;

public class PreguntaOpcionBussines {
	
	@Autowired
	private PreguntaOpcionDao preguntaOpcionDao;
	
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
	
	

}
