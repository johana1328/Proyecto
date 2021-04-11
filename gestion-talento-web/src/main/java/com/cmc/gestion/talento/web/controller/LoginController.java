package com.cmc.gestion.talento.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@GetMapping("/loginPage")
	public String login(
			@RequestParam(name = "error",defaultValue = "false", required = false) boolean error,
			@RequestParam(name = "expired",defaultValue = "false", required = false) boolean expired,
			Model model){
		
		if(error) {
			model.addAttribute("message", "Usuario o contraseña inválidos");
		}
		if(expired) {
			model.addAttribute("message", "Tu sesión ha caducado");
		}
		return "login";
	}
	
}
