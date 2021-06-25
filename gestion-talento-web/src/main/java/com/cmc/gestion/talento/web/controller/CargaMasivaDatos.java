package com.cmc.gestion.talento.web.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cmc.gestion.talento.bussines.CargaMasivaUsuarioBussines;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.gestiondoc.FilesStorageService;

@Controller
@RequestMapping("/administracion/cargadatos")
public class CargaMasivaDatos {

	@Autowired
	private CargaMasivaUsuarioBussines carga;

	@Autowired
	private FilesStorageService filesStorageService;

	@GetMapping
	public String init(@RequestParam(name = "action", defaultValue = "NOK") String action, Model model) {
		model.addAttribute("mensaje", action);
		return "pages/administracion/usuarios/cargaMasivaDatos";
	}

	@GetMapping("/errors")
	public void downloadErrorRepor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Resource resourceFile = filesStorageService.load("error.csv");
		File file = resourceFile.getFile();
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
		response.setContentLength((int) file.length());
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}

	@PostMapping
	public String upload(@RequestParam("file") MultipartFile file) {
		UUID uuidName = UUID.randomUUID();
		String nameFile = uuidName.toString().concat(".").concat(file.getOriginalFilename().split("\\.")[1]);
		filesStorageService.save(file, nameFile);
		try {
			carga.guardarArchivo(nameFile);
		} catch (ArqGestionExcepcion e) {
			return "redirect:/administracion/cargadatos?action=error";
		}
		return "redirect:/administracion/cargadatos";
	}

}
