package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.SolicitudPersonalDto;
import com.cmc.gestion.talento.bussines.facade.SolicitudPersonalFacade;
import com.cmc.gestion.talento.jpa.dao.SolicitudPersonalDao;
import com.cmc.gestion.talento.jpa.entity.Empleado;
import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;
import com.cmc.gestion.talento.jpa.entity.SolicitudDePersonal;
import com.cmc.gestion.talento.jpa.type.TipoEstadoSolicitud;
import com.cmc.gestion.talento.jpa.type.TipoSolicitud;
import com.cmc.gestion.talento.web.security.UserDetail;

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
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetail usuario=(UserDetail)authentication.getPrincipal();
		SolicitudDePersonal solicitudEntity= new SolicitudDePersonal();
		Empleado empleado = new Empleado();
		empleado.setIdUsuario(usuario.getId());
		solicitudEntity.setSolicitante(empleado);
		solicitudEntity.setObservacionSolicitante(solicitud.getObservacionSolicitante());
		solicitudEntity.setFechaCreacion(Calendar.getInstance());
		solicitudEntity.setFechaActualizacion(Calendar.getInstance());
		solicitudEntity.setObservacionGestor("");
		solicitudEntity.setGestor("");
		solicitudEntity.setTipoSolicitud(TipoSolicitud.PERSONAL);
		solicitudEntity.setEstado(TipoEstadoSolicitud.SOLICITUD_CREADA);
		
		//datos solicitud personal
		solicitudEntity.setDescripcionPerfil(solicitud.getDescripcionPerfil());
		solicitudEntity.setCaracteriSoftware(solicitud.getCaracteriSoftware());
		solicitudEntity.setCliente(solicitud.getCliente());
		solicitudEntity.setResponsableCliente(solicitud.getResponsableCliente());
		solicitudEntity.setMesaTrabajo(solicitud.getMesaTrabajo());
		solicitudEntity.setCantidadVacante(Integer.parseInt(solicitud.getCantidadVacante()));
		solicitudEntity.setSalarioAsignado(Double.parseDouble(solicitud.getSalarioAsignado()));
		solicitudEntity.setHorasApagar(Integer.parseInt(solicitud.getHorasApagar()));
		
		solicitudEntity.setAreaSolicitante(solicitud.getAreaSolicitante());
		solicitudEntity.setTipoContrato(solicitud.getTipoContrato());
		solicitudEntity.setEquipoComputo(solicitud.getEquipoComputo());
		solicitudEntity.setEscolaridad(solicitud.getEscolaridad());
		solicitudEntity.setAnoExperienciaMin(solicitud.getAnoExperienciaMin());
		
		long codigoPerfil=solicitud.getCodigoPerfil();
		solicitudEntity.setPerfil(new ParametriaDetalle(codigoPerfil));
		long especialidad= solicitud.getCodigoEspecialidad();
		solicitudEntity.setEspecialidad(new ParametriaDetalle(especialidad));
		long clasePerfil=solicitud.getCodClasePerfil();
		solicitudEntity.setClasePerfil(new ParametriaDetalle(clasePerfil));
		long tarifa=Long.parseLong(solicitud.getCodTarifa());
		solicitudEntity.setTarifa(new ParametriaDetalle(tarifa));
		List<ParametriaDetalle> listaAmbientacion = new ArrayList<>();
		solicitud.getCodAmbientacion().forEach(codigo->{
			ParametriaDetalle p= new ParametriaDetalle(codigo);
			listaAmbientacion.add(p);
		});
		solicitudEntity.setGrupoAmbientacion(listaAmbientacion);
		Calendar cal = Calendar.getInstance();
		cal.setTime(solicitud.getFechaInicio());
		solicitudEntity.setFechaInicio(cal);
		
		solicitudPersonalDao.save(solicitudEntity);

	}

}
