package com.cmc.gestion.talento.bussines.facade;

import java.util.ArrayList;
import java.util.List;

import com.cmc.gestion.talento.bussines.dto.UsuarioDto;
import com.cmc.gestion.talento.jpa.entity.Usuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;
import com.cmc.gestion.talento.web.back.FacadeConvert;

public class UsuarioFacade extends FacadeConvert<UsuarioDto, Usuario> {

	@Override
	protected UsuarioDto mapper(Usuario entidad) {
		UsuarioDto usuario = new UsuarioDto();
		usuario.setIdUsuario(entidad.getIdUsuario());
		usuario.setDocumento(entidad.getDocumento());
		usuario.setTipoDocumento(entidad.getTipoDocumento());
		usuario.setPrimerNombre(entidad.getPrimerNombre());
		usuario.setSegundoNombre(entidad.getSegundoNombre());
		usuario.setPrimerApellido(entidad.getPrimerApellido());
		usuario.setSegundoApellido(entidad.getSegundoApellido());
		usuario.setTelefono(entidad.getTelefono());
		usuario.setCorreoElectronico(entidad.getCorreoElectronico());
		usuario.setFechaCreacion(entidad.getFechaCreacion().getTime());
		usuario.setFechaActualizacion(entidad.getFechaActualizacion().getTime());
		usuario.setEstado(entidad.getEstado());
		if(entidad.getPerfilUsuario() != null) {
			List<TipoPerfil> listaPerfil = new ArrayList<>();
			for(TipoPerfil in : entidad.getPerfilUsuario()) {
				listaPerfil.add(in);
			}
			usuario.setPerfilUsuario(listaPerfil);
		}
		return usuario;
	}

}
