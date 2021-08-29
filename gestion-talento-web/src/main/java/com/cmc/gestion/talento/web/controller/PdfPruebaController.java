package com.cmc.gestion.talento.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfPruebaController {
	
	@GetMapping("")
	public String generatePdf() {
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource();
		
	}

}
