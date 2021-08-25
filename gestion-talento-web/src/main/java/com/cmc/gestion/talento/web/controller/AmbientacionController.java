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

import com.cmc.gestion.talento.bussines.AmbientacionBussines;
import com.cmc.gestion.talento.bussines.dto.AmbientacionDto;
import com.cmc.gestion.talento.web.ModelResponse;
import com.cmc.gestion.talento.web.TypeMessage;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/ambientacion")
public class AmbientacionController {

	@Autowired
	private AmbientacionBussines ambientacionBussines;

	@GetMapping
	public String init() {
		return "pages/administracion/ambientacion";
	}

	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<AmbientacionDto>> getAllAmbientacion() {
		List<AmbientacionDto> resp = ambientacionBussines.getAllAmbientacion();
		return new ResponseEntity<List<AmbientacionDto>>(resp, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> crearAmbiente(@RequestBody @Valid AmbientacionDto ambiente) throws ArqGestionExcepcion {
		try {
			ambientacionBussines.crearAmbientacion(ambiente);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Elemento creado con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@PostMapping(path = "/{id}/get", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ModelResponse> getAmbiente(@PathVariable(required = true) long id)
			throws ArqGestionExcepcion {
		AmbientacionDto resp;
		try {
			resp = ambientacionBussines.getAmbientacion(id);
			ModelResponse model = new ModelResponse(resp, TypeMessage.NO_MESSAGE, null);
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		}

	}

	
	@PostMapping(path = "/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> modificar(@PathVariable(required = true) long id,
			@RequestBody @Valid AmbientacionDto ambientacion) throws ArqGestionExcepcion{
		try {
			ambientacion = ambientacionBussines.actualizarAmbiente(ambientacion);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Ambiente actualizado con exito");
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
			ambientacionBussines.eliminarAmbiente(id);
			ModelResponse model = new ModelResponse(null, TypeMessage.SHOW_MODAL, "Ambiente eliminado con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}

}
