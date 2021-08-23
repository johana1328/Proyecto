package com.cmc.gestion.talento.web.ctl.pruebas;

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
@RequestMapping("/administracion/pruebas/{idPrueba}/preguntas")
public class PruebaPreguntaController {
	
	private static final String PAGE_INDEX="pages/administracion/pruebas/pruebaPregunta";
	
	@Autowired
	private PruebaPreguntaBussines pruebaPreguntaBussines;
	
	

	@GetMapping(path = { "", "/{idPregunta}" })
	public String init(@PathVariable(name = "idPrueba", required = true) Optional<Long> idPrueba,
			@PathVariable(name = "idPregunta", required = false) Optional<Long> idPregunta,
			@RequestParam(name = "action", defaultValue = "NOK") String action, Model model) {
		if(idPregunta.isPresent()) {
			PruebaPreguntaDto pp=pruebaPreguntaBussines.getPregunta(idPregunta.get());
			initOperation(idPrueba.get(), pp,action,model);
		}else {
			initOperation(idPrueba.get(), new PruebaPreguntaDto(),action,model);
		}
		return PAGE_INDEX;
	}
	
	
	@PostMapping("/crear")
	public String crearPregunta(@PathVariable(name = "idPrueba", required = true) Optional<Long> idPrueba,
			@Valid @ModelAttribute("pregunta")PruebaPreguntaDto pregunta,BindingResult result, Model model) {
		if (result.hasErrors()) {
		    initOperation(idPrueba.get(), pregunta, "NOK",model);
			return PAGE_INDEX;
		}
		try {
			pruebaPreguntaBussines.crearPregunta(pregunta,idPrueba.get());
		} catch (ArqGestionExcepcion e) {
			result.addError(new FieldError("pregunta", "enunciado", "El enunciado de la pregunta ya existe."));
			initOperation(idPrueba.get(), pregunta, "NOK",model);
			return PAGE_INDEX;
		}
		return "redirect:/administracion/pruebas/"+idPrueba.get()+"/preguntas?action=create";
	}
	
	@PostMapping("/{idPregunta}/modificar")
	public String modificarPregunta(
			@PathVariable(name = "idPrueba", required = true) Optional<Long> idPrueba,
			@PathVariable(name = "idPregunta", required = true) Optional<Long> idPregunta,
			@Valid @ModelAttribute("pregunta") PruebaPreguntaDto pregunta, BindingResult result, Model model) {
		if (result.hasErrors()) {
			initOperation(idPrueba.get(), pregunta, "NOK", model);
			return PAGE_INDEX;	
		}
		try {
			pregunta.setIdPregunta(idPregunta.get());
			pruebaPreguntaBussines.actualizarPregunta(pregunta);
		} catch (ArqGestionExcepcion e) {
			result.addError(new FieldError("pregunta", "enunciado", "El enunciado de la pregunta ya existe."));
			initOperation(idPrueba.get(), pregunta, "NOK", model);
			return PAGE_INDEX;
		}
		return "redirect:/administracion/pruebas/"+idPrueba.get()+"/preguntas?action=update";
		
	}
	
	
	@PostMapping("/{idPregunta}/eliminar")
	public String eliminarPregunta(
			@PathVariable(name = "idPrueba", required = true) Optional<Long> idPrueba,
			@PathVariable(name = "idPregunta", required = true) Optional<Long> idPregunta) {
	
		try {
			pruebaPreguntaBussines.eliminarPregunta(idPregunta.get());
		} catch (ArqGestionExcepcion e) {
			return "redirect:/administracion/pruebas/"+idPrueba.get()+"/preguntas?action=error-delete";
		}
		return "redirect:/administracion/pruebas/"+idPrueba.get()+"/preguntas?action=delete";
		
	}
	
	private void initOperation(long idPrueba, PruebaPreguntaDto pruebaPregunta, String action, Model model ) {
		List<PruebaPreguntaDto> listaPregunta = new ArrayList<PruebaPreguntaDto>();
		listaPregunta = pruebaPreguntaBussines.getPreguntaByPrueba(idPrueba);
		model.addAttribute("pregunta" , pruebaPregunta);
		model.addAttribute("listaPregunta", listaPregunta);
		model.addAttribute("mensaje", getMensaje(action));
		model.addAttribute("idPrueba", idPrueba);
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
		case "error-delete":
			msg="Error al eliminar la pregunta";
			break;
		default:
			msg=cod;
			break;
		}
		return msg;
	}
	
	
}
