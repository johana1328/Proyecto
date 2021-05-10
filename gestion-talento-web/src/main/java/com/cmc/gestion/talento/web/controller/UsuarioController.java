package com.cmc.gestion.talento.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.UsuarioBussines;
import com.cmc.gestion.talento.bussines.dto.UsuarioDto;


@Controller
@RequestMapping("/administracion/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioBussines usuarioBussines;
	
	@GetMapping
	public String init(Model model ) {
		 List<UsuarioDto> listaJefes=usuarioBussines.getAllJefes();
		model.addAttribute("listaJefes", listaJefes);
		return "pages/administracion/usuarios/crear";
	}

}
