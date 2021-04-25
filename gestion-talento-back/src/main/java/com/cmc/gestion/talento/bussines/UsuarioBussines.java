package com.cmc.gestion.talento.bussines;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.UsuarioDto;
import com.cmc.gestion.talento.bussines.facade.UsuarioFacade;
import com.cmc.gestion.talento.jpa.dao.UsuarioDao;
import com.cmc.gestion.talento.jpa.entity.Usuario;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;

@Service
public class UsuarioBussines {

	@Autowired
	private UsuarioDao usuariodao;


	public UsuarioDto getUsuario(String usuario, String contrasena) {
		UsuarioDto res = null;
		Optional<Usuario> useuarioOptional = usuariodao.findById(usuario);
		if (useuarioOptional.isPresent()) {
			UsuarioFacade userFacade = new UsuarioFacade();
			Usuario usuarioEntity = useuarioOptional.get();
			res = userFacade.getObject(usuarioEntity);
			if (res.getEstado() == TipoEstadoUsuario.ACTIVO && usuarioEntity.getContrasena().equals(contrasena)) {
				return res;
			} else {
				return null;
			}

		}
		return res;
	}

	public List<UsuarioDto> getAllUser() {
		Iterable<Usuario> listUserEntity = usuariodao.findAll();
		UsuarioFacade userFacade = new UsuarioFacade();
		List<UsuarioDto> resp = userFacade.getListObjec(listUserEntity);
		return resp;
	}

}
