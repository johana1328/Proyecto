package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.ClasePerfilDto;
import com.cmc.gestion.talento.bussines.facade.ClasePerfilFacade;
import com.cmc.gestion.talento.jpa.dao.ParametriaDetalleDao;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class ClasePerfilBussines {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ParametriaDetalleDao parametriaDetalle;
	
	@Autowired
	private ClasePerfilFacade clasePerfilFacade;
	
	public List<ClasePerfilDto> getAllClasePerfil(){
		List<ClasePerfilDto> resp= new ArrayList<ClasePerfilDto>();
		try {
		List<ParametriaDetalle>	lisparametria=parametriaDetalle.listParametriaClasePerfil();
		if(!lisparametria.isEmpty()) {
			resp= clasePerfilFacade.getListObject(lisparametria);
		}
		}catch (Exception e) {
			logger.error("Error al consultar la clase de perfil " +e.getMessage());
		}
		return resp;
	}
	
	public ClasePerfilDto getClasePerfil(long id) throws ArqGestionExcepcion{
		Optional<ParametriaDetalle> parametriaOptional=parametriaDetalle.findById(id);
		if(parametriaOptional.isPresent()) {
			ClasePerfilDto clasePerfil = clasePerfilFacade.getObject(parametriaOptional.get());
			return clasePerfil;
		}
		return null;
	}
	
	public void crearClasePerfil(ClasePerfilDto clasePerfil) throws ArqGestionExcepcion{
		List<ParametriaDetalle> lisparametria = this.parametriaDetalle.findByValor(clasePerfil.getClaseperfil());
		if(lisparametria.isEmpty()) {
			ParametriaDetalle parametria= new ParametriaDetalle();
			parametria.setGrupo(TipoParametriaDetalle.CLASE_PERFIL);
			parametria.setDescripcion("clasePerfil valor");
			parametria.setNombre("Clase Perfil");
			parametria.setValor(clasePerfil.getClaseperfil()); //
			this.parametriaDetalle.save(parametria);
		}else {
			throw new ArqGestionExcepcion("Clase perfil ya se encuentra creado", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	public ClasePerfilDto actualizarClasePerfil(ClasePerfilDto clasePerfil) throws ArqGestionExcepcion{
		List<ParametriaDetalle> listParametria= this.parametriaDetalle.findByValor(clasePerfil.getClaseperfil());
		if(listParametria.isEmpty()){
			Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(clasePerfil.getId());
			if(parametriaOptional.isPresent()) {
				ParametriaDetalle parametria=parametriaOptional.get();
				parametria.setValor(clasePerfil.getClaseperfil());
				parametria=this.parametriaDetalle.save(parametria);
				return clasePerfilFacade.getObject(parametria);
			}else {
				return null;
			}
		}else {
			throw new ArqGestionExcepcion("la clase perfil ya se encuentra creada", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	public void eliminarClasePerfil(long id) throws ArqGestionExcepcion{
		Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(id);
		try {
			if(parametriaOptional.isPresent()) {
				ParametriaDetalle parametria=parametriaOptional.get();
				this.parametriaDetalle.delete(parametria);
			}
		}catch (IllegalArgumentException e) {
			throw new ArqGestionExcepcion("Clase perfil se encuentra asociado a una peticion", ExcepcionType.ERROR_VALIDATION);
		}catch (Exception e) {
			throw e;
		}
		
	}
}
