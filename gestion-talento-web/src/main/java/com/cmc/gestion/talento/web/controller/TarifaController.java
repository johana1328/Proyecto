package com.cmc.gestion.talento.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.TarifaBussines;
import com.cmc.gestion.talento.bussines.dto.TarifaDto;

@Controller
@RequestMapping("/administracion/tarifa")
public class TarifaController{
	
	@Autowired
	private TarifaBussines tarifaBussines;
	
	@GetMapping
	public String init() {
		return "pages/administracion/tarifa";
	}
	
	@GetMapping(path =  "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<TarifaDto>> getAllTarifa(){
		List<TarifaDto> resp= tarifaBussines.getAllTarifa();
		return new ResponseEntity<List<TarifaDto>>(resp, HttpStatus.OK);
	}

	
	

}
