package com.cmc.gestion.talento.bussines;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.PruebaDto;
import com.cmc.gestion.talento.bussines.facade.PruebaFacade;
import com.cmc.gestion.talento.jpa.dao.PruebaDao;
import com.cmc.gestion.talento.jpa.entity.Prueba;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class PruebaBussines {
	 
	 
	 @Autowired
	 private PruebaDao pruebaDao;
	 
	 @Autowired
	 private PruebaFacade pruebaFacade;
	 
	 public PruebaDto getPrueba(long idPrueba) {
		 Optional<Prueba>  optionalPrueba =  this.pruebaDao.findById(idPrueba);
		 if (optionalPrueba.isPresent()) {
			 PruebaDto pruebaDto = pruebaFacade.getObject(optionalPrueba.get());
			 return pruebaDto;
		 }
		 return null;
	 }
	 
	 public List<PruebaDto> getallPrueba() {
		Iterable<Prueba> lispruebaEntity = pruebaDao.findAll();
		PruebaFacade pruebaFacade = new PruebaFacade();
		List<PruebaDto> resp = pruebaFacade.getListObjec(lispruebaEntity);
		 return resp;
		 
	 }
	 
	 public void crearPrueba(PruebaDto pruebaDto) throws ArqGestionExcepcion {
		List<Prueba> lisPrueba = pruebaDao.findByNombre(pruebaDto.getNombre());
		if (lisPrueba.isEmpty()) {
			Prueba pruebaEntity = new Prueba();
			pruebaEntity.setNombre(pruebaDto.getNombre());
			pruebaEntity.setDescripcion(pruebaDto.getDescripcion());
			pruebaEntity.setTipoPrueba(pruebaDto.getTipoPrueba());
			pruebaEntity.setEvaluador("SYSTEM");
			pruebaEntity.setEstado(true);
			Calendar fechaActual= Calendar.getInstance();
			pruebaEntity.setFechaCreacion(fechaActual); 
			this.pruebaDao.save(pruebaEntity);
			
		}else{
			throw new ArqGestionExcepcion("La prueba ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
	 }
	
	 
	 public PruebaDto actualizarPrueba(PruebaDto  pruebaDto) throws ArqGestionExcepcion {
		 List<Prueba> lisPrueba = pruebaDao.findByNombre(pruebaDto.getNombre());
			if (lisPrueba.isEmpty()) {
				Optional<Prueba> optionalPrue = this.pruebaDao.findById(pruebaDto.getIdPrueba());
				if (optionalPrue.isPresent()) {
					Prueba pruebaEntity = optionalPrue.get();
					
					pruebaEntity.setNombre(pruebaDto.getNombre());
					pruebaEntity.setDescripcion(pruebaDto.getDescripcion());
					pruebaEntity.setTipoPrueba(pruebaDto.getTipoPrueba());
					this.pruebaDao.save(pruebaEntity);
					return pruebaFacade.getObject(pruebaEntity);
				}else {
					return null;
				}
				}else {
					throw new ArqGestionExcepcion("La prueba ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
			}
	 }
	 
	 public void eliminarPrueba(long idPrueba) throws ArqGestionExcepcion {
		 Optional<Prueba>  optionalPrueba =  this.pruebaDao.findById(idPrueba);
		try { 
			if (optionalPrueba.isPresent()) {
			 Prueba prueba  = optionalPrueba.get();
			 this.pruebaDao.delete(prueba);
			
		}
		}catch (IllegalArgumentException e) {
			throw new ArqGestionExcepcion("La prueba se encuentra asociada a una peticion", ExcepcionType.ERROR_VALIDATION);
		}
	 }

}
