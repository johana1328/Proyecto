package com.cmc.gestion.talento.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administracion/solicitud")
public class solicitudController {
	
	@GetMapping
	public String init(Model model) {
		model.addAttribute("Errror", "NOK");
		return "pages/administracion/peticiones/solicitud";
	}

}
