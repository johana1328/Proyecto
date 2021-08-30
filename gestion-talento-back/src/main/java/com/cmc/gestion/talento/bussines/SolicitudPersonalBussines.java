package com.cmc.gestion.talento.bussines;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.bussines.dto.SolicitudPersonalDto;
import com.cmc.gestion.talento.bussines.facade.SolicitudPersonalFacade;
import com.cmc.gestion.talento.jpa.dao.SolicitudPersonalDao;
import com.cmc.gestion.talento.jpa.entity.Empleado;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.jpa.entity.SolicitudDePersonal;
import com.cmc.gestion.talento.jpa.type.AreaSolicitante;
import com.cmc.gestion.talento.jpa.type.EquipoComputo;
import com.cmc.gestion.talento.jpa.type.NivelEstudios;
import com.cmc.gestion.talento.jpa.type.RangoAnoExperiencia;
import com.cmc.gestion.talento.jpa.type.TipoContrato;
import com.cmc.gestion.talento.jpa.type.TipoEstadoSolicitud;
import com.cmc.gestion.talento.jpa.type.TipoSolicitud;

@Service
public class SolicitudPersonalBussines {
	
	@Autowired
	private SolicitudPersonalDao solicitudPersonalDao;
	
	@Autowired
	private SolicitudPersonalFacade solicitudPersonalFacade;
	
	public List<SolicitudPersonalDto> listarSolicitudesPersonal() {
		List<SolicitudDePersonal> solicitudes=  solicitudPersonalDao.findAll();
		return this.solicitudPersonalFacade.getListObject(solicitudes);
	}
	
	public void crearSolicitudpersonbal(SolicitudPersonalDto solicitud ) {
		
		SolicitudDePersonal solicitudEntity= new SolicitudDePersonal();
		solicitudEntity.setSolicitante(null);
		solicitudEntity.setObservacionSolicitante(solicitud.getObservacionSolicitante());
		
		solicitudEntity.setFechaCreacion(Calendar.getInstance());
		solicitudEntity.setFechaActualizacion(Calendar.getInstance());
		solicitudEntity.setObservacionGestor("");
		solicitudEntity.setGestor("");
		solicitudEntity.setTipoSolicitud(TipoSolicitud.PERSONAL);
		solicitudEntity.setEstado(TipoEstadoSolicitud.SOLICITUD_CREADA);
		
		//datos solicitud personal
		solicitudEntity.setAreaSolicitante(solicitud.getAreaSolicitante());
		solicitudEntity.setPerfil(solicitud.getPerfil());
		solicitudEntity.setEspecialidad(solicitud.getEspecialidad());
		solicitudEntity.setClasePerfil(solicitud.getClasePerfil());
		

	}

}
