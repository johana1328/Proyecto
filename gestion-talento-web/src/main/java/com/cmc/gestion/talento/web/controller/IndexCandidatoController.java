package com.cmc.gestion.talento.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.CandidatoBussines;
import com.cmc.gestion.talento.bussines.dto.CandidatoDto;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/public/registro")
public class IndexCandidatoController {
	
	private  CandidatoDto candidato;
	
	@Autowired
	private CandidatoBussines candidatoBussines;


	@GetMapping
	public String init() {
		return "public/candidato";
	}

	

	@GetMapping(path = { "crear" })
	public String formulario(@PathVariable(name = "id", required = false)Model model) {
		this.candidato = new CandidatoDto();
		model.addAttribute("candidato",candidato);
		return "/public/candidato";
	}
	
	@PostMapping("/crear")
	public String crearCandidato(@Valid @ModelAttribute("candidato") CandidatoDto candidato, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("accion","crear");
			return "/public/candidato";
			
		}
		try {
			candidatoBussines.crearCandidato(candidato);
			System.out.println(candidato);
			
		} catch (ArqGestionExcepcion e) {
			
		}
		return "redirect:/public/candidato?action=create";
	}
	
}