package com.cmc.gestion.talento.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmc.gestion.talento.bussines.PruebaPreguntaBussines;
import com.cmc.gestion.talento.bussines.dto.PruebaPreguntaDto;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/preguntas")
public class PruebaPreguntaController {
	
	@Autowired
	private PruebaPreguntaBussines pruebaPreguntaBussines;
	
	

	@GetMapping("/{idPrueba}")
	public String init(@PathVariable(name = "idPrueba", required = true) Optional<Long> idPrueba,
			@RequestParam(name = "action", defaultValue = "OK") String action, Model model) {
		List<PruebaPreguntaDto> listaPregunta = new ArrayList<PruebaPreguntaDto>();
		if(idPrueba.isPresent()) {
			listaPregunta = pruebaPreguntaBussines.getPreguntaByPrueba(idPrueba.get());
		}
	
		model.addAttribute("pregunta" , new PruebaPreguntaDto());
		model.addAttribute("listaPregunta", listaPregunta);
		model.addAttribute("mensaje", getMensaje(action));
		
		
		
		return "pages/administracion/pruebas/pruebaPregunta";
	}
	
	@PostMapping("/crear")
	public String crearPregunta(@Valid @ModelAttribute("pregunta")PruebaPreguntaDto pregunta,BindingResult result, Model model) {
		if (result.hasErrors()) {
//			initOperation(model, pregunta, "NOK");
			return "pages/administracion/pruebas/pruebaPregunta";
			
		}
		try {
			pruebaPreguntaBussines.crearPregunta(pregunta);
		} catch (ArqGestionExcepcion e) {
			result.addError(new FieldError("pregunta", "enunciado", "El enunciado de la pregunta ya existe."));
//			initOperation(model, pregunta, "NOK");
			return "pages/administracion/pruebas/pruebaPregunta";
		}
		return "redirect:/administracion/pruebas?action=create";
	}
	
	@PostMapping("/modificar/{id}")
	public String modificarPregunta(@PathVariable(name = "id", required = true) Optional<Long> id,
			@Valid @ModelAttribute("pregunta") PruebaPreguntaDto pregunta, BindingResult result, Model model) {
		if (result.hasErrors()) {
//			initOperation(model, pregunta, "NOK");
			return "pages/administracion/pruebas/pruebaPregunta";
			
		}
		try {
			pregunta.setIdPregunta(id.get());
			pruebaPreguntaBussines.actualizarPregunta(pregunta);
			
		} catch (ArqGestionExcepcion e) {
			result.addError(new FieldError("pregunta", "enunciado", "El enunciado de la pregunta ya existe."));
//			initOperation(model, pregunta, "NOK");
			return "pages/administracion/pruebas/pruebaPregunta";
		}
		return "redirect:/administracion/pruebas?action=update";
		
	}
	
	
	
	private String getMensaje(String cod) {
		String msg;
		switch (cod) {
		case "create":
			msg="Peticion creada con exito";
			break;
		case "update":
			msg="Peticion modificada con exito";
			break;
		case "delete":
			msg="Peticion eliminada con exito";
			break;	
		default:
			msg=cod;
			break;
		}
		return msg;
	}
	
//	private void initOperation(Model model,List<PruebaPreguntaDto> pregunta, String action) {
//		model.addAttribute("pregunta" ,pregunta);
//		List<PruebaPreguntaDto> lisPreguntaDto = pruebaPreguntaBussines.getallPregunta();
//		model.addAttribute("listaPregunta", lisPreguntaDto);
//		model.addAttribute("mensaje", getMensaje(action));
//		
//	}
	
	
}
