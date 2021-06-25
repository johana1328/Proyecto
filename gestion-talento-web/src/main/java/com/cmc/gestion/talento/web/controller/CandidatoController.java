package com.cmc.gestion.talento.web.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.cmc.gestion.talento.bussines.CandidatoBussines;
import com.cmc.gestion.talento.bussines.UsuarioBussines;
import com.cmc.gestion.talento.bussines.dto.CandidatoDto;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/candidato")
public class CandidatoController {
	
	private  CandidatoDto candidato;
	
	@Autowired
	private UsuarioBussines usuarioBussines;
	
	@Autowired
	private CandidatoBussines candidatoBussines;

	@GetMapping
	public String init(@PathVariable(name = "id", required = false) Optional<String> id,@RequestParam(name = "action", defaultValue = "NOK") String action, Model model) {
		List<CandidatoDto> listaCandidatos = candidatoBussines.getAllCandidatos();
		model.addAttribute("listaCandidatos", listaCandidatos);
		model.addAttribute("mensaje", getMensaje(action));
		return "pages/administracion/candidato/candidato";
	}

	
	@GetMapping(path = { "crear", "modificar/{id}" })
	public String formulario(@PathVariable(name = "id", required = false) Optional<String> id, Model model) {
		this.candidato = new CandidatoDto();
		model.addAttribute("candidato",candidato);
		return "pages/administracion/candidato/crear";
	}
	
	@PostMapping("/crear")
	public String crearCandidato(@Valid @ModelAttribute("candidato") CandidatoDto candidato, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("accion","crear");
			return "pages/administracion/candidato/crear";
			
		}
		try {
			candidatoBussines.crearCandidato(candidato);
			
		} catch (ArqGestionExcepcion e) {
			
		}
		return "redirect:/administracion/candidato?action=create";
	}
	
	@PostMapping("/modificar/{id}/{action}")
	public String modificarEstadoCandidato(@PathVariable(name = "id", required = true) Optional<String> id,
			@PathVariable(name = "action", required = true) Optional<TipoEstadoUsuario> action) {
		try {
			candidatoBussines.cambiarEstado(id.get(), action.get());
			return "redirect:/administracion/candidato?action=update";
		} catch (ArqGestionExcepcion e) {
			return "redirect:/administracion/candidato?action=errorUpdate";
		}
	}
	
	private String getMensaje(String accion) {
		String resp = null;
		switch (accion) {
		case "create":
			resp = "Usuario creado con exito";
			break;
		case "update":
			resp = "Usuario modificado con exito";
			break;
		case "errorUpdate":
			resp = "Error al modificar el estado  del candidato";
			break;
		default:
			resp="NOK";
			break;
		}
		return resp;
	}


	
}
