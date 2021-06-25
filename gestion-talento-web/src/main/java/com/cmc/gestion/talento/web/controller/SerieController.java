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

import com.cmc.gestion.talento.bussines.SerieBussines;
import com.cmc.gestion.talento.bussines.dto.SerieDto;
import com.cmc.gestion.talento.web.ModelResponse;
import com.cmc.gestion.talento.web.TypeMessage;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;


@Controller
@RequestMapping("/administracion/serie")
public class SerieController {
	@Autowired
	private SerieBussines serieBussines;
	
	@GetMapping
	public String init() {
		return "pages/administracion/serie";
	}
	
	@GetMapping(path = "/getAllSerie", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<SerieDto>> getAllSerie() {
		List<SerieDto> resp = serieBussines.getAllSerie();
		return new ResponseEntity<List<SerieDto>>(resp, HttpStatus.OK);
	}
	
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> crearserie(@RequestBody @Valid SerieDto serieDto) throws ArqGestionExcepcion {
		try {
			serieBussines.crearSerie(serieDto);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Serie creada con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping(path = "/{idSerie}/get", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ModelResponse> getSerie(@PathVariable(required = true, name = "idSerie") long id)
			throws ArqGestionExcepcion {
		SerieDto resp;
		try {
			resp = serieBussines.getSerie(id);
			ModelResponse model = new ModelResponse(resp, TypeMessage.NO_MESSAGE, null);
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		}

	}
	
	@PostMapping(path = "/{idSerie}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> modificar(@PathVariable(required = true , name = "idSerie") long id,
			@RequestBody SerieDto serieDto) throws ArqGestionExcepcion{
		try {
			serieDto = serieBussines.actualizarSerie(serieDto);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Serie actualizada con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		}catch (ArqGestionExcepcion e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@PostMapping(path = "/{idSerie}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> eliminar(@PathVariable(required = true,  name = "idSerie") long id) throws ArqGestionExcepcion {
		try {
			serieBussines.eliminarSerie(id);
			ModelResponse model = new ModelResponse(null, TypeMessage.SHOW_MODAL, "Serie eliminada con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
	

}
