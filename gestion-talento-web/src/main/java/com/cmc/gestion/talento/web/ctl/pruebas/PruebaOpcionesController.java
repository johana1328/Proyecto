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

import com.cmc.gestion.talento.bussines.PreguntaOpcionBussines;
import com.cmc.gestion.talento.bussines.dto.PreguntaOpcionDto;
import com.cmc.gestion.talento.bussines.dto.PruebaPreguntaDto;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/pruebas/preguntas/{idPregunta}/opciones")
public class PruebaOpcionesController {
	private static final String PAGE_INDEX="pages/administracion/pruebas/opcionesPregunta";;

	@Autowired
	private PreguntaOpcionBussines preguntaOpcionBussines;

	@GetMapping(path = { "", "/{idOpcion}" })
	public String init(@PathVariable(name = "idPregunta", required = true) Optional<Long> idPregunta,
			@PathVariable(name = "idOpcion", required = true) Optional<Long> idOpcion,
			@RequestParam(name = "action", defaultValue = "NOK") String action, Model model) {
		initOperation(new PreguntaOpcionDto(), action, model);
		return PAGE_INDEX;
	}

	@PostMapping("/crear")
	public String crearPregunta(@PathVariable(name = "idPregunta", required = true) Optional<Long> idPregunta,
			@Valid @ModelAttribute("opcion") PreguntaOpcionDto opcion, BindingResult result, Model model) {
		if (result.hasErrors()) {
			initOperation(opcion, "NOK", model);
			return PAGE_INDEX;
		}
		try {
			preguntaOpcionBussines.crearOpcion(opcion,idPregunta.get());
		} catch (ArqGestionExcepcion e) {
			result.addError(new FieldError("pregunta", "enunciado", "El enunciado de la pregunta ya existe."));
			initOperation(opcion, "NOK", model);
			return PAGE_INDEX;
		}
		return "redirect:/administracion/pruebas/" + idPregunta.get() + "/preguntas?action=create";
	}

	private void initOperation(PreguntaOpcionDto opcopnDto, String action, Model model) {
		List<PreguntaOpcionDto> listaOpciones = new ArrayList<PreguntaOpcionDto>();
		listaOpciones = preguntaOpcionBussines.getallopcion();
		model.addAttribute("opcion", opcopnDto);
		model.addAttribute("listaOpciones", listaOpciones);
		model.addAttribute("mensaje", getMensaje(action));
	}

	private String getMensaje(String cod) {
		String msg;
		switch (cod) {
		case "create":
			msg = "Peticion creada con exito";
			break;
		case "update":
			msg = "Peticion modificada con exito";
			break;
		case "delete":
			msg = "Peticion eliminada con exito";
			break;
		case "error-delete":
			msg = "Error al eliminar la pregunta";
			break;
		default:
			msg = cod;
			break;
		}
		return msg;
	}
}
