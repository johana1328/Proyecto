package com.cmc.gestion.talento.bussines;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.bussines.facade.EmpleadoFacade;
import com.cmc.gestion.talento.jpa.dao.EmpleadoDao;
import com.cmc.gestion.talento.jpa.entity.Empleado;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

@Service
public class EmpleadoBussines {

	private static final Logger logger = LogManager.getLogger(EmpleadoBussines.class);

	@Autowired
	private EmpleadoDao empleadoDao;

	@Autowired
	private EmpleadoFacade empleadoFacade;

	@Autowired
	private NotificationBussines notificationClinet;

	public List<EmpleadoDto> getAllEmpleados() {
		List<Empleado> listaempleados = this.empleadoDao.findAll();
		return this.empleadoFacade.getListObject(listaempleados);
	}

	public void crearEmpleado(EmpleadoDto empleado) throws ArqGestionExcepcion {
		Optional<Empleado> empleadoOpt = this.empleadoDao.findById(empleado.getIdUsuario());
		if (!empleadoOpt.isPresent()) {
			List<Empleado> listaEmpleados = this.empleadoDao.findByDocumento(empleado.getDocumento());
			if (listaEmpleados.isEmpty()) {
				Empleado empleadoEntity = new Empleado();
				empleadoEntity.setArea(empleado.getArea());
				empleadoEntity.setJefe(empleado.getJefe());
				empleadoEntity.setIdUsuario(empleado.getIdUsuario());
				empleadoEntity.setDocumento(empleado.getDocumento());
				empleadoEntity.setTipoDocumento(empleado.getTipoDocumento());
				empleadoEntity.setPrimerNombre(empleado.getPrimerNombre());
				empleadoEntity.setSegundoNombre(empleado.getSegundoNombre());
				empleadoEntity.setPrimerApellido(empleado.getPrimerApellido());
				empleadoEntity.setSegundoApellido(empleado.getSegundoApellido());
				empleadoEntity.setTelefono(empleado.getTelefono());
				empleadoEntity.setCorreoElectronico(empleado.getCorreoElectronico());
				empleadoEntity.setEstado(TipoEstadoUsuario.CREADO);
				empleadoEntity.setFechaCreacion(Calendar.getInstance());
				empleadoEntity.setFechaActualizacion(Calendar.getInstance());
				List<TipoPerfil> perfilUsuario = Arrays.asList(new TipoPerfil[] { empleado.getPerfil() });
				empleadoEntity.setPerfilUsuario(perfilUsuario);
				empleadoEntity.setContrasena(empleado.getDocumento());
				empleadoDao.save(empleadoEntity);
				this.notificationClinet.notificacionCreacion(empleadoEntity.getCorreoElectronico(),
						empleadoEntity.getIdUsuario(), empleadoEntity.getContrasena());
			} else {
				throw new ArqGestionExcepcion("Existe un documento con el mismo numero",
						ExcepcionType.ERROR_VALIDATION);
			}
		} else {
			throw new ArqGestionExcepcion("Codigo de usuario ya existe", ExcepcionType.ERROR_VALIDATION);
		}
	}
	
	public boolean validarEmpleado(EmpleadoDto empleado) throws ArqGestionExcepcion{
		Optional<Empleado> empleadoOpt = this.empleadoDao.findById(empleado.getIdUsuario());
		if (!empleadoOpt.isPresent()) {
			List<Empleado> listaEmpleados = this.empleadoDao.findByDocumento(empleado.getDocumento());
			if (listaEmpleados.isEmpty()) {
				return true;
			} else {
				throw new ArqGestionExcepcion("Existe un documento con el mismo numero",
						ExcepcionType.ERROR_VALIDATION);
			}
		} else {
			throw new ArqGestionExcepcion("Codigo de usuario ya existe", ExcepcionType.ERROR_VALIDATION);
		}
	}

	public EmpleadoDto getEmpleado(String documento) {
		Optional<Empleado> empleadoOP = this.empleadoDao.findById(documento);
		if (empleadoOP.isPresent()) {
			return this.empleadoFacade.getObject(empleadoOP.get());
		}
		return null;
	}

	public void modificarEmpleado(EmpleadoDto empleado) throws ArqGestionExcepcion {
		Optional<Empleado> empleadoOP = this.empleadoDao.findById(empleado.getIdUsuario());
		if (empleadoOP.isPresent()) {
			Empleado empleadoEntity = empleadoOP.get();
			empleadoEntity.setArea(empleado.getArea());
			empleadoEntity.setJefe(empleado.getJefe());
			empleadoEntity.setDocumento(empleado.getDocumento());
			empleadoEntity.setTipoDocumento(empleado.getTipoDocumento());
			empleadoEntity.setPrimerNombre(empleado.getPrimerNombre());
			empleadoEntity.setSegundoNombre(empleado.getSegundoNombre());
			empleadoEntity.setPrimerApellido(empleado.getPrimerApellido());
			empleadoEntity.setSegundoApellido(empleado.getSegundoApellido());
			empleadoEntity.setTelefono(empleado.getTelefono());
			empleadoEntity.setCorreoElectronico(empleado.getCorreoElectronico());
			empleadoEntity.setFechaActualizacion(Calendar.getInstance());
			List<TipoPerfil> perfilUsuario = Arrays.asList(new TipoPerfil[] { empleado.getPerfil() });
			empleadoEntity.setPerfilUsuario(perfilUsuario);
			empleadoDao.save(empleadoEntity);
		}
	}

	public void cambiarEstado(String idEmpleado, TipoEstadoUsuario estado) throws ArqGestionExcepcion {
		try {
			Optional<Empleado> empleadoOp = empleadoDao.findById(idEmpleado);
			if (empleadoOp.isPresent()) {
				Empleado empleado = empleadoOp.get();
				empleado.setEstado(estado);
				empleado.setContrasena(empleado.getDocumento());
				empleado.setFechaActualizacion(Calendar.getInstance());
				empleadoDao.save(empleado);
				if(estado == TipoEstadoUsuario.RESET) {
					this.notificationClinet.resetpassword(empleado.getCorreoElectronico(), empleado.getIdUsuario(),
							empleado.getDocumento());
				}
				
			}
		} catch (Exception e) {
			logger.error("Error al cambiar estado del usuario " + e.getMessage());
		}
	}

	public void getEmpleados() {
		List<Empleado> emp = this.empleadoDao.findAll();
		for (Empleado in : emp) {
			System.out.println(in.getPrimerNombre());
		}
	}
	

}
