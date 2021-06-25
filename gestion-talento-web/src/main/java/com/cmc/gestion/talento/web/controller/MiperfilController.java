package com.cmc.gestion.talento.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.UsuarioBussines;

@Controller
@RequestMapping("/administracion/miperfil")
public class MiperfilController {
		
  @Autowired
  private UsuarioBussines usuarioBussines;
  
  
		
		
		@GetMapping
		public String init() {
			return "pages/administracion/perfil/miperfil";
		}
	
	}
	
