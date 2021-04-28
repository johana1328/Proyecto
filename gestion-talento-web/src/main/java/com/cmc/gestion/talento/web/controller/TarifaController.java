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

import com.cmc.gestion.talento.bussines.TarifaBussines;
import com.cmc.gestion.talento.bussines.dto.TarifaDto;
import com.cmc.gestion.talento.web.ModelResponse;
import com.cmc.gestion.talento.web.TypeMessage;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/tarifa")
public class TarifaController {

	@Autowired
	private TarifaBussines tarifaBussines;

	@GetMapping
	public String init() {
		return "pages/administracion/tarifa";
	}

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<TarifaDto>> getAllTarifa() {
		List<TarifaDto> resp = tarifaBussines.getAllTarifa();
		return new ResponseEntity<List<TarifaDto>>(resp, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TarifaDto> getAllTarifa(@PathVariable(required = true) long id) {
		TarifaDto resp = tarifaBussines.getTarifa(id);
		return new ResponseEntity<TarifaDto>(resp, HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> crearTarifa(@RequestBody @Valid TarifaDto tarifa) throws ArqGestionExcepcion{
		try {
			tarifaBussines.crearTarifa(tarifa);
			ModelResponse model = new ModelResponse(null, TypeMessage.FROM_MESSAGE, "Tarifa creada con exito");
			return new ResponseEntity<ModelResponse>(model, HttpStatus.OK);
		} catch (ArqGestionExcepcion e) {
			throw e;
		}catch (Exception e) {
			throw e;
		}
	}

	@PostMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TarifaDto> modificar(@PathVariable(required = true) long id, @RequestBody TarifaDto tarifa) {
		try {
			tarifa = tarifaBussines.actualizarTarifa(tarifa);
			return new ResponseEntity<TarifaDto>(tarifa, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}

	@PostMapping(path = "/{id}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ModelResponse> eliminar(@PathVariable(required = true) long id) throws ArqGestionExcepcion {
		try {
			tarifaBussines.eliminarTarifa(id);
			ModelResponse model = new ModelResponse(null, TypeMessage.SHOW_MODAL, "Tarifa eliminada con exito");
			return new ResponseEntity<ModelResponse>(model,HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}

}
