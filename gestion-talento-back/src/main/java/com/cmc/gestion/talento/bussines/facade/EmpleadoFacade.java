package com.cmc.gestion.talento.bussines.facade;

import java.util.Date;
import java.util.List;

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.jpa.entity.Empleado;
import com.cmc.gestion.talento.jpa.type.TipoArea;
import com.cmc.gestion.talento.jpa.type.TipoDocumento;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;
import com.cmc.gestion.talento.web.back.FacadeConvert;

public class EmpleadoFacade extends FacadeConvert<EmpleadoDto,Empleado>{

	@Override
	protected EmpleadoDto mapper(Empleado entidad) {
		EmpleadoDto empleado = new EmpleadoDto();
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
		
//		private Date fechaActualizacion;
//		private List<TipoPerfil> perfilUsuario;
//		private TipoArea area;
//		private String jefe;
		return null;
	}

}
