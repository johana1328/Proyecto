package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.ResetPasswordDto;
import com.cmc.gestion.talento.bussines.dto.UsuarioDto;
import com.cmc.gestion.talento.bussines.facade.UsuarioFacade;
import com.cmc.gestion.talento.jpa.dao.UsuarioDao;
import com.cmc.gestion.talento.jpa.entity.Usuario;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

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
	
	public UsuarioDto getUsuario(String usuario) {
		UsuarioDto res = null;
		Optional<Usuario> useuarioOptional = usuariodao.findById(usuario);
		if (useuarioOptional.isPresent()) {
			UsuarioFacade userFacade = new UsuarioFacade();
			return userFacade.getObject(useuarioOptional.get());
		}
		return res;
	}
	
	public void cambiarPassword(ResetPasswordDto usuario) throws ArqGestionExcepcion{
		Optional<Usuario> useuarioOptional = usuariodao.findById(usuario.getUsuario());
		if (useuarioOptional.isPresent()) {
			Usuario usuarioEntity=useuarioOptional.get();
			TipoEstadoUsuario estado=usuarioEntity.getEstado();
			if(estado==TipoEstadoUsuario.RESET || estado==TipoEstadoUsuario.CREADO) {
				Date ultimefechaActu=usuarioEntity.getFechaActualizacion().getTime();
				Date fechaHoy= new Date();
				int diferenciaDia=fechaHoy.compareTo(ultimefechaActu);
				if(diferenciaDia <= 2) {
					if(usuarioEntity.getContrasena().equals(usuario.getOldPassword())) {
						if(usuario.getNewPassword().equals(usuario.getConfirmNewPassword())) {
							usuarioEntity.setContrasena(usuario.getNewPassword());
							usuarioEntity.setFechaActualizacion(Calendar.getInstance());
							usuarioEntity.setEstado(TipoEstadoUsuario.ACTIVO);
							usuariodao.save(usuarioEntity);
						}else { 
							throw new ArqGestionExcepcion("Las nuevas contraseñas no coinciden", ExcepcionType.ERROR_VALIDATION);
						}
					}else {
						throw new ArqGestionExcepcion("Contraseña no valida", ExcepcionType.ERROR_VALIDATION);
					}
				}else {
					throw new ArqGestionExcepcion("Ha superado el tiempo máximo de habilitación del usuario", ExcepcionType.ERROR_VALIDATION);
				}
			}else {
				throw new ArqGestionExcepcion("Operación no permitida por el usuario", ExcepcionType.ERROR_VALIDATION);
			}
		}else {
			throw new ArqGestionExcepcion("Código de usuario no existe", ExcepcionType.ERROR_VALIDATION);
		}
	}

	public List<UsuarioDto> getAllUser() {
		Iterable<Usuario> listUserEntity = usuariodao.findAll();
		UsuarioFacade userFacade = new UsuarioFacade();
		List<UsuarioDto> resp = userFacade.getListObjec(listUserEntity);
		return resp;
	}
	
	public List<UsuarioDto> getAllJefes(){
		List<TipoPerfil> listaPerfiles= new ArrayList<TipoPerfil>();
		listaPerfiles.add(TipoPerfil.GERENTE);
		List<Usuario> listUserEntity = usuariodao.findByPerfilUsuarioIn(listaPerfiles);
		UsuarioFacade userFacade = new UsuarioFacade();
		List<UsuarioDto> resp = userFacade.getListObjec(listUserEntity);
		return resp;
	}

}
