package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.TipoPerfilDto;
import com.cmc.gestion.talento.bussines.facade.TipoPerfilFacade;
import com.cmc.gestion.talento.jpa.dao.ParametriaDetalleDao;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class TipoPerfilBussines {
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
		
		@Autowired
		private ParametriaDetalleDao parametriaDetalle;
		
		@Autowired
		private TipoPerfilFacade tipoPerfilFacade;
		
		public List<TipoPerfilDto> getAllTipoPerfil(){
			List<TipoPerfilDto> resp= new ArrayList<TipoPerfilDto>();
			try {
			List<ParametriaDetalle>	lisparametria=parametriaDetalle.listParametriaTipoPerfil();
			if(!lisparametria.isEmpty()) {
				resp= tipoPerfilFacade.getListObject(lisparametria);
			}
			}catch (Exception e) {
				logger.error("Error al consultar el tipo perfil " +e.getMessage());
			}
			return resp;
		}
		
		
		public TipoPerfilDto getTipoPerfil(long id) throws ArqGestionExcepcion{
			Optional<ParametriaDetalle> parametriaOptional=parametriaDetalle.findById(id);
			if(parametriaOptional.isPresent()) {
				TipoPerfilDto tipoPerfil = tipoPerfilFacade.getObject(parametriaOptional.get());
				return tipoPerfil;
			}
			return null;
		}
		
		
		public void crearTipoPerfil(TipoPerfilDto tipoPerfil) throws ArqGestionExcepcion{
			List<ParametriaDetalle> lisparametria = this.parametriaDetalle.findByValor(tipoPerfil.getPerfil());
			if(lisparametria.isEmpty()) {
				ParametriaDetalle parametria= new ParametriaDetalle();
				parametria.setGrupo(TipoParametriaDetalle.TIPO_PERFIL);
				parametria.setDescripcion("tipoPerfil valor");
				parametria.setNombre("Tipo Perfil");
				parametria.setValor(tipoPerfil.getPerfil());
				this.parametriaDetalle.save(parametria);
			}else {
				throw new ArqGestionExcepcion("Tipo perfil ya se encuantra creado", ExcepcionType.ERROR_VALIDATION);
			}
		}
		
		
		public TipoPerfilDto actualizarTipoPerfil(TipoPerfilDto tipoPerfil) throws ArqGestionExcepcion{
			List<ParametriaDetalle> listParametria= this.parametriaDetalle.findByValor(tipoPerfil.getPerfil());
			if(listParametria.isEmpty()){
				Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(tipoPerfil.getId());
				if(parametriaOptional.isPresent()) {
					ParametriaDetalle parametria=parametriaOptional.get();
					parametria.setValor(tipoPerfil.getPerfil());
					parametria=this.parametriaDetalle.save(parametria);
					return tipoPerfilFacade.getObject(parametria);
				}else {
					return null;
				}
			}else {
				throw new ArqGestionExcepcion("el perfil ya se encuantra creada", ExcepcionType.ERROR_VALIDATION);
			}
		}
		
		
		public void eliminarTipoPerfil(long id) throws ArqGestionExcepcion{
			Optional<ParametriaDetalle> parametriaOptional=this.parametriaDetalle.findById(id);
			try {
				if(parametriaOptional.isPresent()) {
					ParametriaDetalle parametria=parametriaOptional.get();
					this.parametriaDetalle.delete(parametria);
				}
			}catch (IllegalArgumentException e) {
				throw new ArqGestionExcepcion("Tipo perfil se encuantra asociado a una peticion", ExcepcionType.ERROR_VALIDATION);
			}catch (Exception e) {
				throw e;
			}
			
		}


}
