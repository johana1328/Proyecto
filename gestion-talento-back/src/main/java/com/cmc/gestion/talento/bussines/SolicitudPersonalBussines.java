package com.cmc.gestion.talento.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.jpa.dao.SolicitudPersonalDao;

@Service
public class SolicitudPersonalBussines {
	
	@Autowired
	private SolicitudPersonalDao solicitudPersonalDao;
	
	public void listarSolicitudesPersonal() {
		
	}

}
