package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.EspecialidadDto;
import com.cmc.gestion.talento.bussines.facade.EspecialidadFacade;
import com.cmc.gestion.talento.jpa.dao.ParametriaDetalleDao;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class EspecialidadBussines {

	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());

	  @Autowired
		private ParametriaDetalleDao parametriaDetalle;
	  
	  @Autowired 
	  private EspecialidadFacade especialidadFacade;
	  
	  public List<EspecialidadDto> getAllEspecialidad(){
			List<EspecialidadDto> resp= new ArrayList<EspecialidadDto>();
			try {
			List<ParametriaDetalle>	listparametria=parametriaDetalle.listParametriaEspecialidad();
			if(!listparametria.isEmpty()) {
				resp = especialidadFacade.getListObject(listparametria);
			}
			}catch (Exception e) {
				logger.error("Error al consultar las especialidades" +e.getMessage());
			}
			return resp;
		}
	  
	  public EspecialidadDto getEspecialidad(long id) throws ArqGestionExcepcion{
			Optional<ParametriaDetalle> parametriaOptional=parametriaDetalle.findById(id);
			if(parametriaOptional.isPresent()) {
				EspecialidadDto especialidad = especialidadFacade.getObject(parametriaOptional.get());
				return especialidad;
			}
			return null;
		}
	
	  public void crearEspecialidad(EspecialidadDto especialidad) throws ArqGestionExcepcion{
			List<ParametriaDetalle> lisparametria = this.parametriaDetalle.findByValor(especialidad.getEspecialidad());
			if(lisparametria.isEmpty()) {

				ParametriaDetalle parametria= new ParametriaDetalle();
				parametria.setGrupo(TipoParametriaDetalle.ESPECIALIDAD);
				parametria.setDescripcion("Especialidad valor");
				parametria.setNombre("Especialidad");
				parametria.setValor(especialidad.getEspecialidad());
				this.parametriaDetalle.save(parametria);
			}else {
				throw new ArqGestionExcepcion("La especialidad ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
			}
			
		}
	
	  public EspecialidadDto actualizarEspecialidad(EspecialidadDto especialidad) throws ArqGestionExcepcion{
			List<ParametriaDetalle> listParametria= this.parametriaDetalle.findByValor(especialidad.getEspecialidad());
			if(listParametria.isEmpty()){
				Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(especialidad.getId());
				if(parametriaOptional.isPresent()) {
					ParametriaDetalle parametria=parametriaOptional.get();
					parametria.setValor(especialidad.getEspecialidad());
					parametria=this.parametriaDetalle.save(parametria);
					return especialidadFacade.getObject(parametria);
				}else {
					return null;
				}
			}else {
				throw new ArqGestionExcepcion("La especialidad ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
			}
		}
	
	  public void eliminarEspecialidad(long id) throws ArqGestionExcepcion{
			Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(id);
			try {
				if(parametriaOptional.isPresent()) {
					ParametriaDetalle parametria=parametriaOptional.get();
					this.parametriaDetalle.delete(parametria);
				}
			}catch (IllegalArgumentException e) {
				throw new ArqGestionExcepcion("La especialidad se encuentra asociada a una peticion", ExcepcionType.ERROR_VALIDATION);
			}catch (Exception e) {
				throw e;
			}
			
		}

	
	
}
