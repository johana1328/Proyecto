package com.cmc.gestion.talento.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmc.gestion.talento.bussines.TarifaBussines;
import com.cmc.gestion.talento.bussines.dto.TarifaDto;

@Controller
@RequestMapping("/administracion/tarifa")
public class TarifaController extends AbstractBaseController<TarifaDto>{
	
	 private static final String VIEW_NAME = "pages/analistaRRHH/tarifa";
	 
	 @Autowired
	 private TarifaBussines TarifaBussines;
	 
	 @RequestMapping(path = "/crear", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public ResponseEntity<TarifaDto> crearTarifa(@RequestBody TarifaDto tarifaDto) {
		try {
			TarifaBussines.crearTarifa(tarifaDto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	 }
	 
	 @RequestMapping(path = "/getAll", method = RequestMethod.GET)
	 @ResponseBody
	 public ResponseEntity<List<TarifaDto>> crearTarifa() {
		try {
			List<TarifaDto> rep= getlistObjetRender();
			return new ResponseEntity<List<TarifaDto>>(rep,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	 }
	 
	 
	 

	@Override
	String GetViewName() {
		return VIEW_NAME;
	}

	@Override
	List<TarifaDto> getlistObjetRender() {
		return TarifaBussines.getAllTarifa();
	}

	
	

}
