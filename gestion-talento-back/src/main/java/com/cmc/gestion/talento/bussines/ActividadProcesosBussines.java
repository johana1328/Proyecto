package com.cmc.gestion.talento.bussines;

import java.util.Calendar;

import com.cmc.gestion.talento.jpa.entity.ActividadProcesoSeleccion;
import com.cmc.gestion.talento.jpa.entity.ProcesoSeleccion;

public class ActividadProcesosBussines {
	
	
	public void asignarActividadesPs(ProcesoSeleccion ProcesoSeleccion) {
		ActividadProcesoSeleccion aps = new ActividadProcesoSeleccion();
		aps.setProcesoSeleccion(ProcesoSeleccion);
		aps.setFechaAsignacion(Calendar.getInstance());
		
	}

}
