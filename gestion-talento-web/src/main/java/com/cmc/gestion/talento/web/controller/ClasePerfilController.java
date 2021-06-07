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

import com.cmc.gestion.talento.bussines.ClasePerfilBussines;
import com.cmc.gestion.talento.bussines.dto.ClasePerfilDto;
import com.cmc.gestion.talento.web.ModelResponse;
import com.cmc.gestion.talento.web.TypeMessage;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;



@Controller
@RequestMapping("/administracion/clase-perfil")
public class ClasePerfilController {
	@Autowired
	private ClasePerfilBussines clasePerfilBussines;

	@GetMapping
	public String init() {
		return "pages/administracion/clase-perfil";
	}
	
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<ClasePerfilDto>> getAllClasePerfil() {
		List<ClasePerfilDto> resp = clasePerfilBussines.getAllClasePerfil();
		return new ResponseEntity<List<ClasePerfilDto>>(resp, HttpStatus.OK);
	}
	
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> crearClasePerfil(@RequestBody @Valid ClasePerfilDto clasePerfil) throws ArqGestionExcepcion {
		try {
			clasePerfilBussines.crearClasePerfil(clasePerfil);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Clase perfil creado con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping(path = "/{id}/get", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ModelResponse> getClasePerfil(@PathVariable(required = true) long id)
			throws ArqGestionExcepcion {
		ClasePerfilDto resp;
		try {
			resp = clasePerfilBussines.getClasePerfil(id);
			ModelResponse model = new ModelResponse(resp, TypeMessage.NO_MESSAGE, null);
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		}

	}
	
	@PostMapping(path = "/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> modificar(@PathVariable(required = true) long id,
			@RequestBody ClasePerfilDto clasePerfil) throws ArqGestionExcepcion{
		try {
			clasePerfil = clasePerfilBussines.actualizarClasePerfil(clasePerfil);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Clase perfil actualizado con exito");
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
			clasePerfilBussines.eliminarClasePerfil(id);
			ModelResponse model = new ModelResponse(null, TypeMessage.SHOW_MODAL, "Clase Perfil eliminado con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
}
