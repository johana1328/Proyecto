package com.cmc.gestion.talento.web.controller;

import java.util.UUID;

import org.apache.commons.compress.compressors.FileNameUtil;
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
	public String upload(@RequestParam("file") MultipartFile file) {
		UUID uuidName=UUID.randomUUID();
		String nameFile= uuidName.toString()
				.concat(".")
				.concat(file.getOriginalFilename().split("\\.")[1]);
		filesStorageService.save(file,nameFile);
		carga.guardarArchivo(nameFile);
		return "redirect:/administracion/cargadatos";
	}

}
