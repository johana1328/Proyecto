package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.TarifaDto;
import com.cmc.gestion.talento.bussines.facade.TarifaFacade;
import com.cmc.gestion.talento.jpa.dao.ParametriaDetalleDao;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class TarifaBussines {
	
  private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ParametriaDetalleDao parametriaDetalle;
	
	@Autowired
	private TarifaFacade tarifaFacade;
	
	public List<TarifaDto> getAllTarifa(){
		List<TarifaDto> resp= new ArrayList<TarifaDto>();
		try {
		List<ParametriaDetalle>	lisparametria=parametriaDetalle.listParametriaTarifa();
		if(!lisparametria.isEmpty()) {
			resp= tarifaFacade.getListObject(lisparametria);
		}
		}catch (Exception e) {
			logger.error("Error al consultar las tarifas " +e.getMessage());
		}
		return resp;
	}
	
	public TarifaDto getTarifa(long id) throws ArqGestionExcepcion{
		Optional<ParametriaDetalle> parametriaOptional=parametriaDetalle.findById(id);
		if(parametriaOptional.isPresent()) {
			TarifaDto tarifa = tarifaFacade.getObject(parametriaOptional.get());
			return tarifa;
		}
		return null;
	}
	
	public void crearTarifa(TarifaDto tarifa) throws ArqGestionExcepcion{
		List<ParametriaDetalle> lisparametria = this.parametriaDetalle.findByValor(tarifa.getValor());
		if(lisparametria.isEmpty()) {
			ParametriaDetalle parametria= new ParametriaDetalle();
			parametria.setGrupo(TipoParametriaDetalle.TARIFA);
			parametria.setDescripcion("Tarifa valor");
			parametria.setNombre("Tarifa");
			parametria.setValor(tarifa.getValor());
			this.parametriaDetalle.save(parametria);
		}else {
			throw new ArqGestionExcepcion("La tarifa ya se encuantra creada", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	public TarifaDto actualizarTarifa(TarifaDto tarifa) throws ArqGestionExcepcion{
		List<ParametriaDetalle> listParametria= this.parametriaDetalle.findByValor(tarifa.getValor());
		if(listParametria.isEmpty()){
			Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(tarifa.getId());
			if(parametriaOptional.isPresent()) {
				ParametriaDetalle parametria=parametriaOptional.get();
				parametria.setValor(tarifa.getValor());
				parametria=this.parametriaDetalle.save(parametria);
				return tarifaFacade.getObject(parametria);
			}else {
				return null;
			}
		}else {
			throw new ArqGestionExcepcion("el valor tarifa ya se encuantra creada", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	public void eliminarTarifa(long id) throws ArqGestionExcepcion{
		Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(id);
		try {
			if(parametriaOptional.isPresent()) {
				ParametriaDetalle parametria=parametriaOptional.get();
				this.parametriaDetalle.delete(parametria);
			}
		}catch (IllegalArgumentException e) {
			throw new ArqGestionExcepcion("La tarifa se encuantra asociada a una peticion", ExcepcionType.ERROR_VALIDATION);
		}catch (Exception e) {
			throw e;
		}
		
	}

}
