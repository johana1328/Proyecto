package com.cmc.gestion.talento.bussines;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.jpa.dao.EmpleadoDao;
import com.cmc.gestion.talento.jpa.entity.Empleado;
import com.cmc.gestion.talento.jpa.type.TipoArea;
import com.cmc.gestion.talento.jpa.type.TipoDocumento;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;

@Service
public class EmpleadoBussines {
	
	@Autowired
	private EmpleadoDao empleadoDao;
	
	
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
	
	
	public List<EmpleadoDto> getAllEmpleados(){
		return null;
	}
	
	
	
	public void getEmpleados() {
		List<Empleado> emp=  this.empleadoDao.findAll();
		for(Empleado in : emp) {
			System.out.println(in.getPrimerNombre());
		}
	}

}
