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

import com.cmc.gestion.talento.bussines.EmpleadoBussines;
import com.cmc.gestion.talento.bussines.UsuarioBussines;
import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.bussines.dto.UsuarioDto;


@Controller
@RequestMapping("/administracion/usuario")
public class UsuarioController {
	private EmpleadoDto empleado;
	
	@Autowired
	private UsuarioBussines usuarioBussines;
	
	@Autowired
	private EmpleadoBussines empleadoBussines;
	
	@GetMapping
	public String init(@PathVariable(name = "id", required = false) Optional<String> id,
			Model model ) {
		List<EmpleadoDto> listaEmpleados = empleadoBussines.getAllEmpleados();
		model.addAttribute("listaEmpleados", listaEmpleados);
		return "pages/administracion/usuarios/usuarios";
	}
	
	@GetMapping(path = { "crear", "modificar/{id}" })
	public String formulario(@PathVariable(name = "id", required = false) Optional<String> id,
			Model model ) {
		this.empleado= new EmpleadoDto();
		if(id.isPresent()) {
			this.empleado =this.empleadoBussines.getEmpleado(id.get());
		}
		List<UsuarioDto> listaJefes=usuarioBussines.getAllJefes();
		model.addAttribute("listaJefes", listaJefes);
		model.addAttribute("empleado", this.empleado);
		return "pages/administracion/usuarios/crear";
	}
	
	@PostMapping("/crear")
	public String crearEmpleado(@Valid @ModelAttribute("empleado") EmpleadoDto empleado, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "pages/administracion/pruebas/crearPrueba";
		}
		empleadoBussines.crearEmpleado(empleado);
		return "redirect:/administracion/usuario?action=create";
	}
	
	@PostMapping("/modificar/{id}")
	public String modifocarEmpleado(@PathVariable(name = "id", required = true) Optional<String> id,
			@ModelAttribute("empleado") EmpleadoDto empleado) {
		empleado.setIdUsuario(id.get());
		this.empleadoBussines.modificarEmpleado(empleado);
		return "redirect:/administracion/usuario?action=update";
	}

}
