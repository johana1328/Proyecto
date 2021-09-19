package com.cmc.gestion.talento.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.SolicitudDto;
import com.cmc.gestion.talento.bussines.facade.SolicitudFacade;
import com.cmc.gestion.talento.jpa.dao.SolicitudDao;
import com.cmc.gestion.talento.jpa.entity.Solicitud;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;
import com.cmc.gestion.talento.web.security.UserDetail;

@Service
public class SolicitudBussines {
	
	@Autowired
	private SolicitudDao solicitudDao;
	
	@Autowired
	private SolicitudFacade solicitudFacade;
	
	
	public List<SolicitudDto> getAllSolicitud(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetail usuario = (UserDetail) authentication.getPrincipal();
		TipoPerfil perfil = TipoPerfil.valueOf(usuario.getPerfiles().get(0));
		switch (perfil) {
		case ANALISTA_RRHH:
			return getSolicitudByAnalista(usuario.getId());
		case DIRECTOR: 
            return getSolicitudByGRH();
		case GERENTE_RRHH:
			return getSolicitudByGRH();
		case ANALISTA_PRINCIPAL_RRHH:
			return getSolicitudByGRH();
		default:
			return getSolicitudByGerente(usuario.getId());
		}
	}
	
	
	private List<SolicitudDto> getSolicitudByGerente(String idSuario){
		List<Solicitud> listEntity=solicitudDao.findByGerente(idSuario);
		List<SolicitudDto> resp= solicitudFacade.getListObject(listEntity);
		return resp;
	}
	
	private List<SolicitudDto> getSolicitudByAnalista(String idSuario){
		List<Solicitud> listEntity=solicitudDao.findByAnalista(idSuario);
		List<SolicitudDto> resp= solicitudFacade.getListObject(listEntity);
		return resp;
	}
	
	private List<SolicitudDto> getSolicitudByGRH(){
		List<Solicitud> listEntity=solicitudDao.findAll();
		List<SolicitudDto> resp= solicitudFacade.getListObject(listEntity);
		return resp;
	}

}
