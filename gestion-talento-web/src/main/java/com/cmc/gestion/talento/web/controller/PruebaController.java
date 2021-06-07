package com.cmc.gestion.talento.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.PruebaBussines;
import com.cmc.gestion.talento.bussines.dto.PruebaDto;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/pruebas")
public class PruebaController {
	private PruebaDto pruebaDto;
	private List<PruebaDto> listaPruebaDto;
	
	@Autowired
	private PruebaBussines pruebaBussines;

	@GetMapping(path = {"","/{id}"})
	public String init(Model model,PruebaDto pruebaDto, 
			@PathVariable(name = "id",required = false) Optional<Long> id) {
		this.pruebaDto= new PruebaDto();
		if(id.isPresent()) {
			this.pruebaDto=pruebaBussines.getPrueba(id.get());
		}
		this.listaPruebaDto=pruebaBussines.getallPrueba();
		model.addAttribute("prueba", this.pruebaDto);
		model.addAttribute("listaprueba", this.listaPruebaDto);
		return "pages/administracion/pruebas/crearPrueba";
	}
	
	@PostMapping("/crear")
	public String crearPrueba( @Valid PruebaDto prueba , BindingResult result, Model model) {
		 if (result.hasErrors()) {		
			 this.listaPruebaDto=pruebaBussines.getallPrueba();
			 model.addAttribute("prueba", prueba);
			 model.addAttribute("listaprueba", this.listaPruebaDto);
			 return "pages/administracion/pruebas/crearPrueba";
		    }
		try {
			pruebaBussines.crearPrueba(prueba);
		} catch (ArqGestionExcepcion e) {
			e.printStackTrace();
		}
		return "redirect:/administracion/pruebas";
	}
	
	@PostMapping("/modificar/{id}")
	public String modificarPrueba(Model model, PruebaDto prueba,
			@PathVariable(name = "id",required = true) Optional<Long> id) {
		try {
			prueba.setIdPrueba(id.get());
			pruebaBussines.actualizarPrueba(prueba);
		} catch (ArqGestionExcepcion e) {
			e.printStackTrace();
		}
		return "redirect:/administracion/pruebas";
	}
	
	@PostMapping("/eliminar/{id}")
	public String eliminarPrueba(@PathVariable(name = "id",required = true) Optional<Long> id) {
		try {
			pruebaBussines.eliminarPrueba(id.get());
		} catch (ArqGestionExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/administracion/pruebas";
	}
	
	private void generalInit() {
		
	}
	
	
}
