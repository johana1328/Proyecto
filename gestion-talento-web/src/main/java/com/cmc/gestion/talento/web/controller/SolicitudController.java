package com.cmc.gestion.talento.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.TarifaBussines;
import com.cmc.gestion.talento.bussines.dto.TarifaDto;

@Controller
@RequestMapping("/administracion/solicitud")
public class SolicitudController {
	
	@Autowired
	private TarifaBussines tarifaBussines;
	
	@GetMapping
	public String init(Model model) {
		model.addAttribute("Errror", "NOK");
		return "pages/administracion/peticiones/solicitud";
	}
	
	@GetMapping("/crear")
	public String viewCrear(Model model) {
		List<TarifaDto> tarifas=tarifaBussines.getAllTarifa();
		model.addAttribute("tarifas", tarifas);
		return "pages/administracion/peticiones/crearSP";
	}

}
