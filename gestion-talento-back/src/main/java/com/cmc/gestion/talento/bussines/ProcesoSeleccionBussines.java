package com.cmc.gestion.talento.bussines;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmc.gestion.talento.jpa.dao.ProcesoSeleccionDao;
import com.cmc.gestion.talento.jpa.entity.ProcesoSeleccion;

public class ProcesoSeleccionBussines {
	
	@Autowired
	ProcesoSeleccionDao procesoSeleccionDao;
	
	public void asociarCandidatoProceso() {
		ProcesoSeleccion ps= new ProcesoSeleccion();
		
		
		//procesoSeleccionDao
	}

}
