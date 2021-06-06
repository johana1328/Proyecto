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

import com.cmc.gestion.talento.bussines.CompetenciaCorporativaBussines;
import com.cmc.gestion.talento.bussines.dto.CompetenciaCorporativaDto;
import com.cmc.gestion.talento.web.ModelResponse;
import com.cmc.gestion.talento.web.TypeMessage;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;


@Controller
@RequestMapping("/administracion/competencia-corporativa")
public class CompetenciaCorporativaController {
	@Autowired
	private CompetenciaCorporativaBussines competenciaCorporativaBussines;

	@GetMapping
	public String init() {
		return "pages/administracion/competencia-corporativa";
	}
	
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<CompetenciaCorporativaDto>> getAllCompetenciaCorporativa() {
		List<CompetenciaCorporativaDto> resp = competenciaCorporativaBussines.getAllCompetenciaCorporativa();
		return new ResponseEntity<List<CompetenciaCorporativaDto>>(resp, HttpStatus.OK);
	}
	
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> crearCompetenciaCorporativa(@RequestBody @Valid CompetenciaCorporativaDto competenciaCorporativa) throws ArqGestionExcepcion {
		try {
			competenciaCorporativaBussines.crearCompetenciaCorporativa(competenciaCorporativa);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Competencia Corporativa creada con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping(path = "/{id}/get", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ModelResponse> getCompetenciaCorporativa(@PathVariable(required = true) long id)
			throws ArqGestionExcepcion {
		CompetenciaCorporativaDto resp;
		try {
			resp = competenciaCorporativaBussines.getCompetenciaCorporativa(id);
			ModelResponse model = new ModelResponse(resp, TypeMessage.NO_MESSAGE, null);
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		}

	}
	
	@PostMapping(path = "/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> modificar(@PathVariable(required = true) long id,
			@RequestBody CompetenciaCorporativaDto competenciaCorporativa) throws ArqGestionExcepcion{
		try {
			competenciaCorporativa = competenciaCorporativaBussines.actualizarCompetenciaCorporativa(competenciaCorporativa);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Competencia Corporativa actualizada con exito");
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
			competenciaCorporativaBussines.eliminarCompetenciaCorporativa(id);
			ModelResponse model = new ModelResponse(null, TypeMessage.SHOW_MODAL, "Competencia Corporativa eliminada con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
}
