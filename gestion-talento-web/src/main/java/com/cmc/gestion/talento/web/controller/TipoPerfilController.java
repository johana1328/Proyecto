package com.cmc.gestion.talento.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.cmc.gestion.talento.bussines.TipoPerfilBussines;
import com.cmc.gestion.talento.bussines.dto.TarifaDto;
import com.cmc.gestion.talento.bussines.dto.TipoPerfilDto;
import com.cmc.gestion.talento.web.ModelResponse;
import com.cmc.gestion.talento.web.TypeMessage;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/tipo-perfil")
public class TipoPerfilController {
	@Autowired
	private TipoPerfilBussines tipoPerfilBussines;

	@GetMapping
	public String init() {
		return "pages/administracion/tipo-perfil";
	}
	
	
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<TipoPerfilDto>> getAllTipoPerfil() {
		List<TipoPerfilDto> resp = tipoPerfilBussines.getAllTipoPerfil();
		return new ResponseEntity<List<TipoPerfilDto>>(resp, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> crearTipoPerfil(@RequestBody @Valid TipoPerfilDto tipoPerfil) throws ArqGestionExcepcion {
		try {
			tipoPerfilBussines.crearTipoPerfil(tipoPerfil);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Tipo perfil creado con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@PostMapping(path = "/{id}/get", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ModelResponse> getTipoPerfil(@PathVariable(required = true) long id)
			throws ArqGestionExcepcion {
		TipoPerfilDto resp;
		try {
			resp = tipoPerfilBussines.getTipoPerfil(id);
			ModelResponse model = new ModelResponse(resp, TypeMessage.NO_MESSAGE, null);
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		}

	}
	
	
	@PostMapping(path = "/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> modificar(@PathVariable(required = true) long id,
			@RequestBody TipoPerfilDto tipoPerfil) throws ArqGestionExcepcion{
		try {
			tipoPerfil = tipoPerfilBussines.actualizarTipoPerfil(tipoPerfil);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Tipo perfil actualizado con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		}catch (ArqGestionExcepcion e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@PostMapping(path = "/{id}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> eliminar(@PathVariable(required = true) long id) throws ArqGestionExcepcion {
		try {
			tipoPerfilBussines.eliminarTipoPerfil(id);
			ModelResponse model = new ModelResponse(null, TypeMessage.SHOW_MODAL, "Tipo Perfil eliminado con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
}
