package com.cmc.gestion.talento.web.ctl.solicitud;

import java.util.List;

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

import com.cmc.gestion.talento.bussines.AmbientacionBussines;
import com.cmc.gestion.talento.bussines.ClasePerfilBussines;
import com.cmc.gestion.talento.bussines.EspecialidadBussines;
import com.cmc.gestion.talento.bussines.SolicitudPersonalBussines;
import com.cmc.gestion.talento.bussines.TarifaBussines;
import com.cmc.gestion.talento.bussines.TipoPerfilBussines;
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
	
	@GetMapping(path = {"","/{id}"})
	public String viewCrear(Model model) {
		List<TarifaDto> tarifas=tarifaBussines.getAllTarifa();
		List<EspecialidadDto> especialidades = especialidadBussines.getAllEspecialidad();
		List<TipoPerfilDto> perfiles = tipoPerfilBussines.getAllTipoPerfil();
		List<AmbientacionDto> ambientaciones = ambientacionBussines.getAllAmbientacion();
		List<ClasePerfilDto> clasesPerfil = clasePerfilBussines.getAllClasePerfil();
		model.addAttribute("solicitud", new SolicitudPersonalDto());
		model.addAttribute("tarifas", tarifas);
		model.addAttribute("especialidades", especialidades);
		model.addAttribute("perfiles", perfiles);
		model.addAttribute("ambientaciones", ambientaciones);
		model.addAttribute("clasesPerfil", clasesPerfil);
		model.addAttribute("mensaje", "NOK");
		return "pages/peticiones/personal/crearEditar";
	}
	
	@GetMapping("/{id}/detalle")
	public String detalle(@PathVariable(name = "id", required = true) Long id) throws ArqGestionExcepcion {
		return "pages/peticiones/personal/detalle";
	}
	
	@PostMapping("/crear")
	public String crearSolicitud(@Valid @ModelAttribute("solicitud") SolicitudPersonalDto solicitud, 
			BindingResult result,
			Model model) throws ArqGestionExcepcion {
		   solicitudPersonalBussines.crearSolicitud(solicitud);
		System.out.println(solicitud);
		return "redirect:/administracion/solicitud";
	}

}
