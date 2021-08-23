package com.cmc.gestion.talento.web.ctl.pruebas;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.cmc.gestion.talento.bussines.PruebaBussines;
import com.cmc.gestion.talento.bussines.dto.PruebaDto;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.controller.LoginController;

@Controller
@RequestMapping("/administracion/pruebas")
public class PruebaController {

	private static final Logger logger = LogManager.getLogger(LoginController.class);
	

	@Autowired
	private PruebaBussines pruebaBussines;

	@GetMapping(path = { "", "/{id}" })
	public String init(@PathVariable(name = "id", required = false) Optional<Long> id,
			@RequestParam(name = "action", defaultValue = "NOK") String action, Model model) {
		PruebaDto prueba = new PruebaDto();
		if (id.isPresent()) {
			prueba = pruebaBussines.getPrueba(id.get());
		}
		initOperation(model, prueba,action);
		return "pages/administracion/pruebas/crearPrueba";
	}

	@PostMapping("/crear")
	public String crearPrueba(@Valid @ModelAttribute("prueba") PruebaDto prueba, BindingResult result, Model model) {
		if (result.hasErrors()) {
			initOperation(model, prueba, "NOK");
			return "pages/administracion/pruebas/crearPrueba";
		}
		try {
			pruebaBussines.crearPrueba(prueba);
		} catch (ArqGestionExcepcion e) {
			result.addError(new FieldError("prueba", "nombre", "El nombre de la prueba ya existe."));
			initOperation(model, prueba, "NOK");
			return "pages/administracion/pruebas/crearPrueba";
		}
		return "redirect:/administracion/pruebas?action=create";
	}

	@PostMapping("/modificar/{id}")
	public String modificarPrueba(@PathVariable(name = "id", required = true) Optional<Long> id,
			@Valid @ModelAttribute("prueba") PruebaDto prueba, BindingResult result, Model model) {
		if (result.hasErrors()) {
			initOperation(model, prueba, "NOK");
			return "pages/administracion/pruebas/crearPrueba";
		}
		try {
			prueba.setIdPrueba(id.get());
			pruebaBussines.actualizarPrueba(prueba);
		} catch (ArqGestionExcepcion e) {
			result.addError(new FieldError("prueba", "nombre", "El nombre de la prueba ya existe."));
			initOperation(model, prueba, "NOK");
			return "pages/administracion/pruebas/crearPrueba";
		}
		return "redirect:/administracion/pruebas?action=update";
	}

	@PostMapping("/eliminar/{id}")
	public String eliminarPrueba(@PathVariable(name = "id", required = true) Optional<Long> id)
			throws ArqGestionExcepcion {
		try {
			pruebaBussines.eliminarPrueba(id.get());
		} catch (ArqGestionExcepcion e) {
			logger.error("Error al eliminar prueba" + e.getMessage());
			throw e;
		}
		return "redirect:/administracion/pruebas?action=delete";
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
	
	private void initOperation( Model model, PruebaDto prueba, String action) {
		model.addAttribute("prueba", prueba);
		List<PruebaDto> listaPruebaDto = pruebaBussines.getallPrueba();
		model.addAttribute("listaprueba", listaPruebaDto);
		model.addAttribute("mensaje", getMensaje(action));
	}

}
