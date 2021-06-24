package com.cmc.gestion.talento.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cmc.gestion.talento.bussines.CargaMasivaUsuarioBussines;
import com.cmc.gestion.talento.web.gestiondoc.FilesStorageService;

@Controller
@RequestMapping("/administracion/cargadatos")
public class CargaMasivaDatos {
	
	@Autowired
	private CargaMasivaUsuarioBussines carga;
	
	@Autowired
	private FilesStorageService filesStorageService;

	@GetMapping
	public String init() {
		return "pages/administracion/usuarios/cargaMasivaDatos";
	}
	
	@PostMapping
	public void upload(@RequestParam("file") MultipartFile file) {
		filesStorageService.save(file);
		carga.guardarArchivo(file.getOriginalFilename());
	}

}
