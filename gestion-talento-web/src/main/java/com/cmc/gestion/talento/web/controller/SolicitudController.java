package com.cmc.gestion.talento.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.AmbientacionBussines;
import com.cmc.gestion.talento.bussines.EspecialidadBussines;
import com.cmc.gestion.talento.bussines.TarifaBussines;
import com.cmc.gestion.talento.bussines.TipoPerfilBussines;
import com.cmc.gestion.talento.bussines.dto.AmbientacionDto;
import com.cmc.gestion.talento.bussines.dto.EspecialidadDto;
import com.cmc.gestion.talento.bussines.dto.TarifaDto;
import com.cmc.gestion.talento.bussines.dto.TipoPerfilDto;

@Controller
@RequestMapping("/administracion/solicitud")
public class SolicitudController {
	
	@Autowired
	private TarifaBussines tarifaBussines;
	
	@Autowired
	private AmbientacionBussines ambientacionBussines;
	
	@Autowired
	private TipoPerfilBussines tipoPerfilBussines;
	
	@Autowired
	private EspecialidadBussines especialidadBussines;
	
	@GetMapping
	public String init(Model model) {
		model.addAttribute("Errror", "NOK");
		return "pages/administracion/peticiones/solicitud";
	}
	
	@GetMapping("/crear")
	public String viewCrear(Model model) {
		List<TarifaDto> tarifas=tarifaBussines.getAllTarifa();
		List<EspecialidadDto> especialidades = especialidadBussines.getAllEspecialidad();
		List<TipoPerfilDto> perfiles = tipoPerfilBussines.getAllTipoPerfil();
		List<AmbientacionDto> ambientaciones = ambientacionBussines.getAllAmbientacion();
		model.addAttribute("tarifas", tarifas);
		model.addAttribute("especialidades", especialidades);
		model.addAttribute("perfiles", perfiles);
		model.addAttribute("ambientaciones", ambientaciones);
		return "pages/administracion/peticiones/crearSP";
	}

}
