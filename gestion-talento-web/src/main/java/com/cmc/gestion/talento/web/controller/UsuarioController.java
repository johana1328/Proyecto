package com.cmc.gestion.talento.web.controller;

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

import com.cmc.gestion.talento.bussines.EmpleadoBussines;
import com.cmc.gestion.talento.bussines.NotificationBussines;
import com.cmc.gestion.talento.bussines.UsuarioBussines;
import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.bussines.dto.UsuarioDto;
import com.cmc.gestion.talento.jpa.type.TipoEstadoUsuario;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/usuario")
public class UsuarioController {

	private EmpleadoDto empleado;

	@Autowired
	private UsuarioBussines usuarioBussines;

	@Autowired
	private EmpleadoBussines empleadoBussines;

	@GetMapping
	public String init(@PathVariable(name = "id", required = false) Optional<String> id,@RequestParam(name = "action", defaultValue = "NOK") String action, Model model) {
		List<EmpleadoDto> listaEmpleados = empleadoBussines.getAllEmpleados();
		model.addAttribute("listaEmpleados", listaEmpleados);
		model.addAttribute("mensaje", getMensaje(action));
		
		return "pages/administracion/usuarios/usuarios";
	}

	@GetMapping(path = { "crear", "modificar/{id}" })
	public String formulario(@PathVariable(name = "id", required = false) Optional<String> id, Model model) {
		this.empleado = new EmpleadoDto();
		if (id.isPresent()) {
			this.empleado = this.empleadoBussines.getEmpleado(id.get());
			model.addAttribute("accion","modificar");
		}else {
			model.addAttribute("accion","crear");
		}
		
		List<UsuarioDto> listaJefes = usuarioBussines.getAllJefes();
		model.addAttribute("listaJefes", listaJefes);
		model.addAttribute("empleado", this.empleado);
		return "pages/administracion/usuarios/crear";
	}

	@PostMapping("/crear")
	public String crearEmpleado(@Valid @ModelAttribute("empleado") EmpleadoDto empleado, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("accion","crear");
			return "pages/administracion/usuarios/crear";
		}
		try {
			empleadoBussines.crearEmpleado(empleado);
		} catch (ArqGestionExcepcion e) {
			result.addError(new FieldError("prueba", "nombre", e.getMessage()));
			List<UsuarioDto> listaJefes = usuarioBussines.getAllJefes();
			model.addAttribute("accion","crear");
			model.addAttribute("listaJefes", listaJefes);
			return "pages/administracion/usuarios/crear";
		}
		return "redirect:/administracion/usuario?action=create";
	}

	@PostMapping("/modificar/{id}")
	public String modifocarEmpleado(@PathVariable(name = "id", required = true) Optional<String> id,
			@Valid @ModelAttribute("empleado") EmpleadoDto empleado, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "pages/administracion/usuarios/crear";
		}

		try {
			empleadoBussines.modificarEmpleado(empleado);
		} catch (ArqGestionExcepcion e) {
			result.addError(new FieldError("prueba", "nombre", e.getMessage()));
			List<UsuarioDto> listaJefes = usuarioBussines.getAllJefes();
			model.addAttribute("listaJefes", listaJefes);
			return "pages/administracion/usuarios/crear";
		}

		return "redirect:/administracion/usuario?action=update";
	}

	@PostMapping("/modificar/{id}/{action}")
	public String modifocarEstadoEmpleado(@PathVariable(name = "id", required = true) Optional<String> id,
			@PathVariable(name = "action", required = true) Optional<TipoEstadoUsuario> action) {
		try {
			empleadoBussines.cambiarEstado(id.get(), action.get());
			return "redirect:/administracion/usuario?action=update";
		} catch (ArqGestionExcepcion e) {
			return "redirect:/administracion/usuario?action=errorUpdate";
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
			resp = "Error al modificar el estado  el usuario";
			break;
		default:
			resp="NOK";
			break;
		}
		return resp;
	}

}
