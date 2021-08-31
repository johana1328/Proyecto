package com.cmc.gestion.talento.web.ctl.solicitud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmc.gestion.talento.bussines.SolicitudBussines;
import com.cmc.gestion.talento.bussines.dto.SolicitudDto;

@Controller
@RequestMapping("/administracion/solicitud")
public class SolicitudController {
	
	@Autowired
	private SolicitudBussines solicitudBussines;
	
	@GetMapping
	public String init(@RequestParam(name = "action", defaultValue = "NOK") String action, Model model) {
		List<SolicitudDto> solicitudes=  solicitudBussines.getAllSolicitud();
		model.addAttribute("Errror", action);
		model.addAttribute("solicitudes", solicitudes);
		return "pages/peticiones/solicitudes";
	}
	
	@GetMapping("/{id}")
	public String detalle(@PathVariable(name = "id", required = true) Long id) {
		String SolicitudPersonalUrl="redirect:/administracion/solicitud/personal/";
		return SolicitudPersonalUrl+id+"/detalle";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(@RequestParam(name = "action", defaultValue = "NOK") String action, Model model) {
		List<SolicitudDto> solicitudes=  solicitudBussines.getAllSolicitud();
		model.addAttribute("Errror", action);
		model.addAttribute("solicitudes", solicitudes);
		return "pages/peticiones/solicitudes";
	}
	
	@PostMapping("/{id}/eliminar")
	public String eliminar(@RequestParam(name = "action", defaultValue = "NOK") String action, Model model) {
		List<SolicitudDto> solicitudes=  solicitudBussines.getAllSolicitud();
		model.addAttribute("Errror", action);
		model.addAttribute("solicitudes", solicitudes);
		return "pages/peticiones/solicitudes";
	}
	
	@PostMapping("/{id}/asignar")
	public String asignar(@RequestParam(name = "action", defaultValue = "NOK") String action, Model model) {
		List<SolicitudDto> solicitudes=  solicitudBussines.getAllSolicitud();
		model.addAttribute("Errror", action);
		model.addAttribute("solicitudes", solicitudes);
		return "pages/peticiones/solicitudes";
	}
}
