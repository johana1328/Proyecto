package com.cmc.gestion.talento.web.ctl.solicitud;

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

import com.cmc.gestion.talento.bussines.AmbientacionBussines;
import com.cmc.gestion.talento.bussines.ClasePerfilBussines;
import com.cmc.gestion.talento.bussines.EspecialidadBussines;
import com.cmc.gestion.talento.bussines.SolicitudPersonalBussines;
import com.cmc.gestion.talento.bussines.TarifaBussines;
import com.cmc.gestion.talento.bussines.TipoPerfilBussines;
import com.cmc.gestion.talento.bussines.UsuarioBussines;
import com.cmc.gestion.talento.bussines.dto.AmbientacionDto;
import com.cmc.gestion.talento.bussines.dto.ClasePerfilDto;
import com.cmc.gestion.talento.bussines.dto.EspecialidadDto;
import com.cmc.gestion.talento.bussines.dto.SolicitudPersonalDto;
import com.cmc.gestion.talento.bussines.dto.TarifaDto;
import com.cmc.gestion.talento.bussines.dto.TipoPerfilDto;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;

@Controller
@RequestMapping("/administracion/solicitud/personal")
public class SolicitudPersonalController {
	
	@Autowired
	private SolicitudPersonalBussines solicitudPersonalBussines;
	
	@Autowired
	private TarifaBussines tarifaBussines;
	
	@Autowired
	private AmbientacionBussines ambientacionBussines;
	
	@Autowired
	private TipoPerfilBussines tipoPerfilBussines;
	
	@Autowired
	private EspecialidadBussines especialidadBussines;
	
	@Autowired
	private ClasePerfilBussines clasePerfilBussines;
	
	@Autowired
	private UsuarioBussines usuarioBussines;
	
	@GetMapping(path = {"","/{id}"})
	public String viewCrear(Model model, @PathVariable(name = "id", required = false) Optional<Long> id) {
		List<TarifaDto> tarifas=tarifaBussines.getAllTarifa();
		List<EspecialidadDto> especialidades = especialidadBussines.getAllEspecialidad();
		List<TipoPerfilDto> perfiles = tipoPerfilBussines.getAllTipoPerfil();
		List<AmbientacionDto> ambientaciones = ambientacionBussines.getAllAmbientacion();
		List<ClasePerfilDto> clasesPerfil = clasePerfilBussines.getAllClasePerfil();
		SolicitudPersonalDto sp =new SolicitudPersonalDto();
		if(id.isPresent()) {
			model.addAttribute("solicitud", solicitudPersonalBussines.getSolicitud(id.get()));
		}else {
			model.addAttribute("solicitud", sp);
		}
		model.addAttribute("tarifas", tarifas);
		model.addAttribute("especialidades", especialidades);
		model.addAttribute("perfiles", perfiles);
		model.addAttribute("ambientaciones", ambientaciones);
		model.addAttribute("clasesPerfil", clasesPerfil);
		model.addAttribute("mensaje", "NOK");
		return "pages/peticiones/personal/crearEditar";
	}
	
	@GetMapping("/{id}/detalle")
	public String detalle(@PathVariable(name = "id", required = true) Long id,
			Model model) throws ArqGestionExcepcion {
		model.addAttribute("analistas", usuarioBussines.getAllAnalistaAndLider());
		model.addAttribute("solicitud", solicitudPersonalBussines.getSolicitud(id));
		return "pages/peticiones/personal/detalle";
	}
	
	@PostMapping("/crear")
	public String crearSolicitud(@Valid @ModelAttribute("solicitud") SolicitudPersonalDto solicitud, 
			BindingResult result,
			Model model) throws ArqGestionExcepcion {
		    solicitudPersonalBussines.crearSolicitud(solicitud);
		  return "redirect:/administracion/solicitud";
	}
	
	@PostMapping("/modificar/{id}")
	public String modificarSolicitud(@PathVariable(name = "id", required = true) Optional<Long> id,
			@Valid @ModelAttribute("solicitud") SolicitudPersonalDto solicitud, 
			BindingResult result,
			Model model) throws ArqGestionExcepcion {
			if (result.hasErrors()) {
				//initOperation(model, prueba, "NOK");
				return "pages/peticiones/personal/crearEditar";
			}
			try {
				solicitud.setIdSolicitud(id.get());
				solicitudPersonalBussines.actualizarSolicitud(solicitud);
			} catch (ArqGestionExcepcion e) {
				result.addError(new FieldError("prueba", "nombre", "El nombre de la prueba ya existe."));
				//initOperation(model, prueba, "NOK");
				return "pages/administracion/pruebas/crearPrueba";
			}
		  return "redirect:/administracion/solicitud";
	}
	
	
	@GetMapping("/{id}/asignar/{idEmpleado}")
	public String asignar(@PathVariable(name = "id", required = true) long id,
			              @PathVariable(name = "idEmpleado", required = true) String idEmpleado) {
		solicitudPersonalBussines.asignarSolicitud(idEmpleado,id);
		return "redirect:/administracion/solicitud";
	}
	
	@GetMapping("/{id}/asignar/{idCandidato}")
	public String asociarCandidato(@PathVariable(name = "id", required = true) long id,
			              @PathVariable(name = "idEmpleado", required = true) String idEmpleado) {
		solicitudPersonalBussines.asignarSolicitud(idEmpleado,id);
		return "redirect:/administracion/solicitud";
	}
	

}
