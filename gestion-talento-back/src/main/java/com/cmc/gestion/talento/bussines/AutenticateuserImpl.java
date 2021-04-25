package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.UsuarioDto;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;
import com.cmc.gestion.talento.web.security.AutenticateUser;
import com.cmc.gestion.talento.web.security.UserDetail;

@Service
public class AutenticateuserImpl implements AutenticateUser {

	@Autowired
	UsuarioBussines usuarioBussines;

	@Override
	public UserDetail autenticate(String user, String password) {
		UsuarioDto usuario = this.usuarioBussines.getUsuario(user, password);
		if (usuario != null) {
			UserDetail userdetail = new UserDetail();
			List<String> perfiles = new ArrayList<String>();
			for (TipoPerfil in : usuario.getPerfilUsuario()) {
				perfiles.add(in.toString());
			}
			userdetail.setPerfiles(perfiles);
			userdetail.setNombre(usuario.getPrimerNombre().concat(" ").concat(usuario.getPrimerApellido()));
			return userdetail;
		}
		return null;
	}

}
