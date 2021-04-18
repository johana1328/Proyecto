package com.cmc.gestion.talento.bussines.facade;

import java.util.ArrayList;
import java.util.List;

import com.cmc.gestion.talento.bussines.dto.PerfilDto;
import com.cmc.gestion.talento.bussines.dto.UsuarioDto;
import com.cmc.gestion.talento.jpa.entity.Perfil;
import com.cmc.gestion.talento.jpa.entity.Usuario;

public class UsuarioFacade extends FacadeConvert<UsuarioDto, Usuario> {

	@Override
	protected UsuarioDto mapper(Usuario entidad) {
		UsuarioDto user = new UsuarioDto();
		user.setIdUsuario(entidad.getIdUsuario());
		user.setNombres(entidad.getNombres());
		user.setApellidos(entidad.getApellidos());
		user.setUsuario(entidad.getUsuario());
		user.setEstado(entidad.getEstado());
		user.setCorreoElectronico(entidad.getCorreoElectronico());
		user.setArea(entidad.getArea());
		user.setJefe(entidad.getJefe());
		user.setApellidos(entidad.getApellidos());
		List<PerfilDto> listPerfil = new ArrayList<PerfilDto>();
		for(Perfil inPerfil: entidad.getUsPerfils()) {
			PerfilDto perfil = new PerfilDto();
			perfil.setCodigoPerfil(inPerfil.getCodigoPerfil());
			perfil.setGrupoPerfil(inPerfil.getGrupoPerfil());
			perfil.setNombre(inPerfil.getNombre());
			listPerfil.add(perfil);
		}
		user.setUsPerfils(listPerfil);
		return user;
	}

}
