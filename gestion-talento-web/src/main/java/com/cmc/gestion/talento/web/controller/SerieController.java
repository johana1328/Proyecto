package com.cmc.gestion.talento.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.SerieBussines;
import com.cmc.gestion.talento.bussines.dto.SerieDto;


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
	
	

}
