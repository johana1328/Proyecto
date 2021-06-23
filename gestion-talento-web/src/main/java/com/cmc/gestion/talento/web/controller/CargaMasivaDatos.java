package com.cmc.gestion.talento.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/administracion/cargadatos")
public class CargaMasivaDatos {

	@GetMapping
	public String init() {
		return "pages/administracion/usuarios/cargaMasivaDatos";
	}
	
	@PostMapping
	public void upload(@RequestParam("file") MultipartFile file) {
		
	}

}
