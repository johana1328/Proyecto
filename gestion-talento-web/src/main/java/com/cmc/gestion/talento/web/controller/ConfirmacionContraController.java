package com.cmc.gestion.talento.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/confirmacionContrasena")
public class ConfirmacionContraController {
	
	@GetMapping
	public String init() {
		return "public/confirmacionContrasena";
	}
	
	@PostMapping
	public String cambioContrasena() {
		return "public/confirmacionContrasena";
	}

}
