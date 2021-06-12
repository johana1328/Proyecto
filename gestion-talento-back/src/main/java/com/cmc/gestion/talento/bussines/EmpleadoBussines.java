package com.cmc.gestion.talento.bussines;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.bussines.facade.EmpleadoFacade;
import com.cmc.gestion.talento.jpa.dao.EmpleadoDao;
import com.cmc.gestion.talento.jpa.entity.Empleado;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;

@Service
public class EmpleadoBussines {
	
	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Autowired
	private EmpleadoFacade empleadoFacade;
	
	
	public void crearEmpleado(EmpleadoDto empleado) {
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
		List<TipoPerfil> perfilUsuario = Arrays.asList(new TipoPerfil[] {empleado.getPerfil()});
		empleadoEntity.setPerfilUsuario(perfilUsuario);
		empleadoEntity.setContrasena("1234");
		empleadoDao.save(empleadoEntity);
	}
	
	
	public EmpleadoDto getEmpleado(String documento) {
		Optional<Empleado> empleadoOP= this.empleadoDao.findById(documento);
		if(empleadoOP.isPresent()) {
			return this.empleadoFacade.getObject(empleadoOP.get());
		}
		return null;
	}
	
	
	public void modificarEmpleado(EmpleadoDto empleado) {
		Optional<Empleado> empleadoOP= this.empleadoDao.findById(empleado.getIdUsuario());
		if(empleadoOP.isPresent()) {
			Empleado empleadoEntity=empleadoOP.get();
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
			List<TipoPerfil> perfilUsuario = Arrays.asList(new TipoPerfil[] {empleado.getPerfil()});
			empleadoEntity.setPerfilUsuario(perfilUsuario);
			try {
				empleadoDao.save(empleadoEntity);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	public List<EmpleadoDto> getAllEmpleados(){
		List<Empleado> listaempleados=  this.empleadoDao.findAll();
		return this.empleadoFacade.getListObject(listaempleados);
	}
	
	public void cambiarEstado(String idEmpleado, TipoEstadoUsuario estado) {
		Optional<Empleado>  empleadoOp= empleadoDao.findById(idEmpleado);
		if(empleadoOp.isPresent()) {
			Empleado empleado=empleadoOp.get();
			empleado.setEstado(estado);
			empleadoDao.save(empleado);
		}
		
	}
	
	
	
	public void getEmpleados() {
		List<Empleado> emp=  this.empleadoDao.findAll();
		for(Empleado in : emp) {
			System.out.println(in.getPrimerNombre());
		}
	}

}
