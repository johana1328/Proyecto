package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.AmbientacionDto;
import com.cmc.gestion.talento.bussines.facade.AmbientacionFacade;
import com.cmc.gestion.talento.jpa.dao.ParametriaDetalleDao;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class AmbientacionBussines {

	  private Logger logger = LoggerFactory.getLogger(this.getClass());

	  @Autowired
		private ParametriaDetalleDao parametriaDetalle;
	  
	  @Autowired 
	  private AmbientacionFacade ambientacionFacade;
	  
	  
	  public List<AmbientacionDto> getAllAmbientacion(){
			List<AmbientacionDto> resp= new ArrayList<AmbientacionDto>();
			try {
			List<ParametriaDetalle>	listparametria=parametriaDetalle.listParametriaAmbiente();
			if(!listparametria.isEmpty()) {
				resp = ambientacionFacade.getListObject(listparametria);
			}
			}catch (Exception e) {
				logger.error("Error al consultar los ambientes" +e.getMessage());
			}
			return resp;
		}
	  
	  
	  public AmbientacionDto getAmbientacion(long id) throws ArqGestionExcepcion{
			Optional<ParametriaDetalle> parametriaOptional=parametriaDetalle.findById(id);
			if(parametriaOptional.isPresent()) {
				AmbientacionDto ambientacion = ambientacionFacade.getObject(parametriaOptional.get());
				return ambientacion;
			}
			return null;
		}
	  
	  
	  public void crearAmbientacion(AmbientacionDto ambientacion) throws ArqGestionExcepcion{
			List<ParametriaDetalle> lisparametria = this.parametriaDetalle.findByValor(ambientacion.getAmbiente());
			if(lisparametria.isEmpty()) {

				ParametriaDetalle parametria= new ParametriaDetalle();
				parametria.setGrupo(TipoParametriaDetalle.AMBIENTE);
				parametria.setDescripcion("Ambiente valor");
				parametria.setNombre("Ambiente");
				parametria.setValor(ambientacion.getAmbiente());
				this.parametriaDetalle.save(parametria);
			}else {
				throw new ArqGestionExcepcion("El ambiente ya se encuentra creado", ExcepcionType.ERROR_VALIDATION);
			}
			
		}
	  public AmbientacionDto actualizarAmbiente(AmbientacionDto ambientacion) throws ArqGestionExcepcion{
			List<ParametriaDetalle> listParametria= this.parametriaDetalle.findByValor(ambientacion.getAmbiente());
			if(listParametria.isEmpty()){
				Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(ambientacion.getId());
				if(parametriaOptional.isPresent()) {
					ParametriaDetalle parametria=parametriaOptional.get();
					parametria.setValor(ambientacion.getAmbiente());
					parametria=this.parametriaDetalle.save(parametria);
					return ambientacionFacade.getObject(parametria);
				}else {
					return null;
				}
			}else {
				throw new ArqGestionExcepcion("El ambiente ya se encuentra creado", ExcepcionType.ERROR_VALIDATION);
			}
		}
		
		public void eliminarAmbiente(long id) throws ArqGestionExcepcion{
			Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(id);
			try {
				if(parametriaOptional.isPresent()) {
					ParametriaDetalle parametria=parametriaOptional.get();
					this.parametriaDetalle.delete(parametria);
				}
			}catch (IllegalArgumentException e) {
				throw new ArqGestionExcepcion("El ambiente se encuentra asociada a una peticion", ExcepcionType.ERROR_VALIDATION);
			}catch (Exception e) {
				throw e;
			}
			
		}

		
		
	
}
