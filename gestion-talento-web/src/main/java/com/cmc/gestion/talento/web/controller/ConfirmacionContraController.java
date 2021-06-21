package com.cmc.gestion.talento.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.UsuarioBussines;
import com.cmc.gestion.talento.bussines.dto.ResetPasswordDto;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/public/confirmacionContrasena")
public class ConfirmacionContraController {
	
	@Autowired
	private UsuarioBussines usuarioBussines;
	
	@GetMapping
	public String init(Model model) {
		model.addAttribute("empleado", new ResetPasswordDto());
		return "public/confirmacionContrasena";
		
	}
	
	@PostMapping
	public String cambioContrasena(@Valid @ModelAttribute("empleado") ResetPasswordDto empleado, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "public/confirmacionContrasena";
		}
		try {
			usuarioBussines.cambiarPassword(empleado);
		} catch (ArqGestionExcepcion e) {
			result.addError(new FieldError("empleado", "usuario", e.getMessage()));
			model.addAttribute("empleado", empleado);
			return "public/confirmacionContrasena";
		}
		return "redirect:/loginPage";
	}

}
