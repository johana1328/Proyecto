package com.cmc.gestion.talento.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administracion/curriculum/academica")
public class formacionAcademicaController {

	@GetMapping
	public String init() {
		return "pages/administracion/curriculum/academica";
	}

}
