package com.cmc.gestion.talento.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/indexcandidato")
public class IndexCandidatoController {

	@GetMapping
	public String init() {
		return "public/candidato";
	}

}