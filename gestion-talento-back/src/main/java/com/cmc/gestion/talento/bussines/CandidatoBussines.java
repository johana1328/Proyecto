package com.cmc.gestion.talento.bussines;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.CandidatoDto;
import com.cmc.gestion.talento.bussines.facade.CandidatoFacade;
import com.cmc.gestion.talento.jpa.dao.CandidatoDao;
import com.cmc.gestion.talento.jpa.entity.Candidato;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class CandidatoBussines {
	
	private static final Logger logger = LogManager.getLogger(CandidatoBussines.class);
	@Autowired
	private CandidatoDao candidatoDao;
	
	@Autowired
	private CandidatoFacade candidatoFacade;
	
	@Autowired
	private NotificationBussines notificationClinet;
	
	public List<CandidatoDto> getAllCandidatos(){
		List<Candidato> listaCandidatos = this.candidatoDao.findAll();
		return this.candidatoFacade.getListObjec(listaCandidatos);
	}
	
	public void crearCandidato(CandidatoDto candidato) throws ArqGestionExcepcion {
		Optional<Candidato> candidatoOp = this.candidatoDao.findById(candidato.getDocumento());
		if (!candidatoOp.isPresent()) {
			List<Candidato>listaCandidato = candidatoDao.findByDocumento(candidato.getDocumento());
		if (listaCandidato.isEmpty()) {
			Candidato candidatoEntity = new Candidato();
			candidatoEntity.setIdUsuario(candidato.getDocumento());
			candidatoEntity.setDocumento(candidato.getDocumento());
			candidatoEntity.setTipoDocumento(candidato.getTipoDocumento());
			candidatoEntity.setPrimerNombre(candidato.getPrimerNombre());
			candidatoEntity.setSegundoNombre(candidato.getSegundoNombre());
			candidatoEntity.setPrimerApellido(candidato.getPrimerApellido());
			candidatoEntity.setSegundoApellido(candidato.getSegundoApellido());
			candidatoEntity.setTelefono(candidato.getTelefono());
			candidatoEntity.setCorreoElectronico(candidato.getCorreoElectronico());
			candidatoEntity.setEstado(TipoEstadoUsuario.CREADO);
			candidatoEntity.setFechaCreacion(Calendar.getInstance());
			candidatoEntity.setFechaActualizacion(Calendar.getInstance());
			List<TipoPerfil> perfilUsuario = Arrays.asList(new TipoPerfil[] { TipoPerfil.CANDIDATO});
			candidatoEntity.setPerfilUsuario(perfilUsuario);
			candidatoEntity.setContrasena(candidato.getDocumento());
			candidatoEntity.setTituloProfesional(candidato.getTituloProfesional());
			boolean isTrabajoActual = candidato.getTrabajoActual().equals("si");
			candidatoEntity.setTrabajoActual(isTrabajoActual);
			double salarioActual = Double.parseDouble(candidato.getSalarioActual());
			candidatoEntity.setSalarioActual(salarioActual);
			candidatoEntity.setTipoContrato(candidato.getTipoContrato());
			double aspiracionSalarial = Double.parseDouble(candidato.getAspiracionSalarial());
			candidatoEntity.setAspiracionSalarial(aspiracionSalarial);
			boolean salarioFlexible = candidato.getSalarioFlexible().equals("si");
			candidatoEntity.setSalarioFlexible(salarioFlexible);
			int disponibilidad= Integer.parseInt(candidato.getDisponibilidad());
			candidatoEntity.setDisponibilidad(disponibilidad);
			candidatoEntity.setObservaciones(candidato.getObservaciones());
			candidatoEntity.setObjetivos(candidato.getObjetivos());
			candidatoEntity.setOrigenHoja(candidato.getOrigenHoja());
			candidatoDao.save(candidatoEntity);		
			this.notificationClinet.inscripcionCandidato(candidatoEntity.getCorreoElectronico());
		} else {
			throw new ArqGestionExcepcion("Existe un documento con el mismo numero",
					ExcepcionType.ERROR_VALIDATION);
		}
	} else {
		throw new ArqGestionExcepcion("Codigo de usuario ya existe", ExcepcionType.ERROR_VALIDATION);
	}
	
}
	public void cambiarEstado(String idCandidato, TipoEstadoUsuario estado) throws ArqGestionExcepcion {
		try {
			Optional<Candidato> candidatoOp = candidatoDao.findById(idCandidato);
			if (candidatoOp.isPresent()) {
				Candidato candidato = candidatoOp.get();
				candidato.setEstado(estado);
				candidato.setContrasena(candidato.getDocumento());
				candidato.setFechaActualizacion(Calendar.getInstance());
				candidatoDao.save(candidato);
				if(estado == TipoEstadoUsuario.RESET) {
					this.notificationClinet.resetpassword(candidato.getCorreoElectronico(), candidato.getIdUsuario(),
							candidato.getDocumento());
				}
				
			}
		} catch (Exception e) {
			logger.error("Error al cambiar estado del usuario " + e.getMessage());
		}
	}
	
}
