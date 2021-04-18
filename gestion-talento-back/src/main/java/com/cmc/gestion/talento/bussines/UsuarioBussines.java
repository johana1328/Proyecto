package com.cmc.gestion.talento.bussines;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.PerfilDto;
import com.cmc.gestion.talento.bussines.dto.UsuarioDto;
import com.cmc.gestion.talento.bussines.facade.UsuarioFacade;
import com.cmc.gestion.talento.jpa.dao.UsuarioDao;
import com.cmc.gestion.talento.jpa.entity.Perfil;
import com.cmc.gestion.talento.jpa.entity.Usuario;

@Service
public class UsuarioBussines {
	
	@Autowired
	private UsuarioDao usuariodao;
	
  public UsuarioDto getUsuario(String usuario,String contrasena) {
	  UsuarioDto res = null;
	 Optional<Usuario> optionalUsuario = usuariodao.getUsuarioLogin(usuario, contrasena);
	 if (optionalUsuario.isPresent()) {
		 UsuarioFacade userFacade = new UsuarioFacade();
		 Usuario usuarioEntity=optionalUsuario.get();
		 System.out.println(usuarioEntity.getUsPerfils().size());
		 res=userFacade.getObject(usuarioEntity);
		 return res;
	}else
		return null;
  }
  
  public List<UsuarioDto> getAllUser(){
	    Iterable<Usuario> listUserEntity= usuariodao.findAll();
	    UsuarioFacade userFacade = new UsuarioFacade();
	    List<UsuarioDto> resp=userFacade.getListObject(listUserEntity);
	    return resp;
  }

	
}
