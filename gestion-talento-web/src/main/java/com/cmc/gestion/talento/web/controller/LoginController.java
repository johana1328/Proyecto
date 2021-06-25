package com.cmc.gestion.talento.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Controller
public class LoginController {
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
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
		logger.debug("Login OK:");
		return "login";
	}
	
}
