package com.cmc.gestion.talento.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.SerieBussines;
import com.cmc.gestion.talento.bussines.SubserieBussines;
import com.cmc.gestion.talento.bussines.dto.SerieDto;
import com.cmc.gestion.talento.bussines.dto.SubserieDto;
import com.cmc.gestion.talento.web.ModelResponse;
import com.cmc.gestion.talento.web.TypeMessage;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/subserie")
public class SubserieController {
	
	@Autowired
	private SerieBussines serieBussines;
	
	@Autowired
	private SubserieBussines subserieBussines;
	
	@GetMapping
	public String init(Model model) {
		List<SerieDto> liataSerire =this.serieBussines.getAllSerie();
		model.addAttribute("liataSerire", liataSerire);
		return "pages/administracion/subserie";
	}

	@GetMapping(path = "/getAllSubserie", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<SubserieDto>> getAllSubserie() {
		List<SubserieDto> resp = subserieBussines.getAllSubserie();
		return new ResponseEntity<List<SubserieDto>>(resp, HttpStatus.OK);
	}
	
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> crearSubserie(@RequestBody SubserieDto subserieDto) throws ArqGestionExcepcion {
		try {
			subserieBussines.crearSubserie(subserieDto);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Subserie creada con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
	@PostMapping(path = "/{id}/get", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ModelResponse> getSubserie(@PathVariable(required = true) long id)
			throws ArqGestionExcepcion {
		SubserieDto resp;
		try {
			resp = subserieBussines.getSubserie(id);
			ModelResponse model = new ModelResponse(resp, TypeMessage.NO_MESSAGE, null);
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		}

	}
	
	@PostMapping(path = "/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> modificar(@PathVariable(required = true ) long id,
			@RequestBody SubserieDto subserieDto) throws ArqGestionExcepcion{
		try {
			subserieDto = subserieBussines.actualizarSubserie(subserieDto);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Subserie actualizada con exito");
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
			subserieBussines.eliminarSubserie(id);
			ModelResponse model = new ModelResponse(null, TypeMessage.SHOW_MODAL, "Subserie eliminada con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	

}
