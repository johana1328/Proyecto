package com.cmc.gestion.talento;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cmc.gestion.talento.web.gestiondoc.FilesStorageService;

@SpringBootApplication
public class GestionTalento implements CommandLineRunner{
	
	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(GestionTalento.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		storageService.init();
	}

}
