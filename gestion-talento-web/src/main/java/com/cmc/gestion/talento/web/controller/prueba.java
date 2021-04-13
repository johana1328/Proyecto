package com.cmc.gestion.talento.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class prueba {
	 @GetMapping("/errorEjemplo")
	    public String form(Model model) {
	        return "errors/error403";
	    }
	 
	 

}
