package com.cmc.gestion.talento.bussines.facade;

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.jpa.entity.Empleado;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;


@FacadeService
public class EmpleadoFacade extends FacadeConvert<EmpleadoDto,Empleado>{

	@Override
	protected EmpleadoDto mapper(Empleado entidad) {
		EmpleadoDto empleado = new EmpleadoDto();
		
		empleado.setArea(entidad.getArea());
		empleado.setJefe(entidad.getJefe());
		empleado.setIdUsuario(entidad.getIdUsuario());
		empleado.setDocumento(entidad.getDocumento());
		empleado.setTipoDocumento(entidad.getTipoDocumento());
		empleado.setPrimerNombre(entidad.getPrimerNombre());
		empleado.setSegundoNombre(entidad.getSegundoNombre());
	    empleado.setPrimerApellido(entidad.getPrimerApellido());
	    empleado.setSegundoApellido(entidad.getSegundoApellido());
	    empleado.setTelefono(entidad.getTelefono());
		empleado.setCorreoElectronico(entidad.getCorreoElectronico());
	    empleado.setContrasena(entidad.getContrasena());
		empleado.setEstado(entidad.getEstado());
		empleado.setFechaCreacion(entidad.getFechaCreacion().getTime());
		empleado.setFechaActualizacion(entidad.getFechaActualizacion().getTime());
		empleado.setPerfil(entidad.getPerfilUsuario().get(0));
		return empleado;
	}

}
