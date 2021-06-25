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

import com.cmc.gestion.talento.bussines.EspecialidadBussines;
import com.cmc.gestion.talento.bussines.dto.AmbientacionDto;
import com.cmc.gestion.talento.bussines.dto.EspecialidadDto;
import com.cmc.gestion.talento.web.ModelResponse;
import com.cmc.gestion.talento.web.TypeMessage;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/especialidad")

public class EspecialidadController {
	
	
	@Autowired
	private EspecialidadBussines especialidadBussines;

	@GetMapping
	public String init() {
		return "pages/administracion/especialidad";
	}

	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<EspecialidadDto>> getAllEspecialidad() {
		List<EspecialidadDto> resp = especialidadBussines.getAllEspecialidad();
		return new ResponseEntity<List<EspecialidadDto>>(resp, HttpStatus.OK);
	}
	
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> crearEspecialidad(@RequestBody @Valid EspecialidadDto especialidad) throws ArqGestionExcepcion {
		try {
			especialidadBussines.crearEspecialidad(especialidad);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Elemento creado con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@PostMapping(path = "/{id}/get", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ModelResponse> getEspecialidad(@PathVariable(required = true) long id)
			throws ArqGestionExcepcion {
		EspecialidadDto resp;
		try {
			resp = especialidadBussines.getEspecialidad(id);
			ModelResponse model = new ModelResponse(resp, TypeMessage.NO_MESSAGE, null);
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		}

	}
	
	@PostMapping(path = "/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> modificar(@PathVariable(required = true) long id,
			@RequestBody EspecialidadDto especialidad) throws ArqGestionExcepcion{
		try {
			especialidad = especialidadBussines.actualizarEspecialidad(especialidad);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Especialidad actualizada con exito");
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
			especialidadBussines.eliminarEspecialidad(id);
			ModelResponse model = new ModelResponse(null, TypeMessage.SHOW_MODAL, "Especialidad eliminada con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	

}
