package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.CompetenciaCorporativaDto;
import com.cmc.gestion.talento.bussines.facade.CompetenciaCorporativaFacade;
import com.cmc.gestion.talento.jpa.dao.ParametriaDetalleDao;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class CompetenciaCorporativaBussines {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ParametriaDetalleDao parametriaDetalle;
	
	@Autowired
	private CompetenciaCorporativaFacade competenciaCorporativaFacade;
	
	public List<CompetenciaCorporativaDto> getAllCompetenciaCorporativa(){
		List<CompetenciaCorporativaDto> resp= new ArrayList<CompetenciaCorporativaDto>();
		try {
		List<ParametriaDetalle>	lisparametria=parametriaDetalle.listParametriaCompetenciaCorporativa();
		if(!lisparametria.isEmpty()) {
			resp= competenciaCorporativaFacade.getListObject(lisparametria);
		}
		}catch (Exception e) {
			logger.error("Error al consultar la competencia corporativa " +e.getMessage());
		}
		return resp;
	}
	
	public CompetenciaCorporativaDto getCompetenciaCorporativa(long id) throws ArqGestionExcepcion{
		Optional<ParametriaDetalle> parametriaOptional=parametriaDetalle.findById(id);
		if(parametriaOptional.isPresent()) {
			CompetenciaCorporativaDto competenciaCorporativa = competenciaCorporativaFacade.getObject(parametriaOptional.get());
			return competenciaCorporativa;
		}
		return null;
	}
	
	public void crearCompetenciaCorporativa(CompetenciaCorporativaDto competenciaCorporativa) throws ArqGestionExcepcion{
		List<ParametriaDetalle> lisparametria = this.parametriaDetalle.findByValor(competenciaCorporativa.getNombre());
		if(lisparametria.isEmpty()) {
			ParametriaDetalle parametria= new ParametriaDetalle();
			parametria.setGrupo(TipoParametriaDetalle.COMPETENCIA_CORPORATIVA);
			parametria.setDescripcion(competenciaCorporativa.getDescripcion());
			parametria.setNombre(competenciaCorporativa.getNombre());
			parametria.setValor(competenciaCorporativa.getNombre());  //
			this.parametriaDetalle.save(parametria);
		}else {
			throw new ArqGestionExcepcion("Competencia Corporativa ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	public CompetenciaCorporativaDto actualizarCompetenciaCorporativa(CompetenciaCorporativaDto competenciaCorporativa) throws ArqGestionExcepcion{
		List<ParametriaDetalle> listParametria= this.parametriaDetalle.findByValor(competenciaCorporativa.getNombre());
		if(listParametria.isEmpty()){
			Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(competenciaCorporativa.getId());
			if(parametriaOptional.isPresent()) {
				ParametriaDetalle parametria=parametriaOptional.get();
				parametria.setNombre(competenciaCorporativa.getNombre());
				parametria.setDescripcion(competenciaCorporativa.getDescripcion());
				parametria=this.parametriaDetalle.save(parametria);
				return competenciaCorporativaFacade.getObject(parametria);
			}else {
				return null;
			}
		}else {
			throw new ArqGestionExcepcion("La competencia corporativa ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	public void eliminarCompetenciaCorporativa(long id) throws ArqGestionExcepcion{
		Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(id);
		try {
			if(parametriaOptional.isPresent()) {
				ParametriaDetalle parametria=parametriaOptional.get();
				this.parametriaDetalle.delete(parametria);
			}
		}catch (IllegalArgumentException e) {
			throw new ArqGestionExcepcion("Competencia Corporativa se encuentra asociado a una peticion", ExcepcionType.ERROR_VALIDATION);
		}catch (Exception e) {
			throw e;
		}
		
	}
}
