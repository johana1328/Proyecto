package com.cmc.gestion.talento.bussines;

import java.util.Calendar;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.jpa.dao.CandidatoDao;
import com.cmc.gestion.talento.jpa.dao.ProcesoSeleccionDao;
import com.cmc.gestion.talento.jpa.dao.SolicitudPersonalDao;
import com.cmc.gestion.talento.jpa.entity.Candidato;
import com.cmc.gestion.talento.jpa.entity.ProcesoSeleccion;
import com.cmc.gestion.talento.jpa.entity.ProcesoSeleccionPk;
import com.cmc.gestion.talento.jpa.entity.SolicitudDePersonal;
import com.cmc.gestion.talento.jpa.type.TipoEstadoSeleccion;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;

@Service
public class ProcesoSeleccionBussines {
	
	@Autowired
	ProcesoSeleccionDao procesoSeleccionDao;
	
	@Autowired
	CandidatoDao candidatoDao;
	
	@Autowired
	private SolicitudPersonalDao solicitudPersonalDao;
	
	@Autowired
	private NotificationBussines notificationClinet;

	
	
	public void asociarCandidatoProceso(String idCandidato, long idSolicitud) {
		Optional<Candidato> cabdidatoOp=  candidatoDao.findById(idCandidato);
		Optional<SolicitudDePersonal> solicitudOp  =solicitudPersonalDao.findById(idSolicitud);
		if(cabdidatoOp.isPresent() && solicitudOp.isPresent()) {
			ProcesoSeleccionPk pk = new ProcesoSeleccionPk();
			pk.setCandidato(cabdidatoOp.get());
			pk.setSolicitudDePersonal(solicitudOp.get());
			ProcesoSeleccion ps= new ProcesoSeleccion();
			ps.setProcesoSeleccionPk(pk);
			ps.setEstado(TipoEstadoSeleccion.ASOCIADO);
			ps.setFechaAsociacion(Calendar.getInstance());
			ProcesoSeleccion psCreado=  procesoSeleccionDao.save(ps);
			Candidato candidato= cabdidatoOp.get();
			candidato.setEstado(TipoEstadoUsuario.ACTIVO);
			candidatoDao.save(candidato);
			Candidato candidato = new Candidato();
			this.notificationClinet.notificacionCreacion(candidato.getCorreoElectronico(),
														 candidato.getIdUsuario(),
														 candidato.getContrasena());
			
		}
		
		
	}

}
