package com.cmc.gestion.talento.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.gestion.talento.bussines.CandidatoBussines;
import com.cmc.gestion.talento.bussines.UsuarioBussines;
import com.cmc.gestion.talento.bussines.dto.CandidatoDto;
import com.cmc.gestion.talento.bussines.dto.UsuarioDto;
import com.cmc.gestion.talento.web.security.UserDetail;

@Controller
@RequestMapping("/administracion/miperfil")
public class MiperfilController {
		
  @Autowired
  private UsuarioBussines usuarioBussines;
  
  @Autowired
  private CandidatoBussines candidatoBussines;
		
		
		@GetMapping(path = {"","/{idUsuario}"})
		public String init(Model model,
				@PathVariable(name = "idUsuario", required = false) Optional<String> idUsuarioParam) {
			String codUsuario=null;
			boolean isCandidato=false;
			if(idUsuarioParam.isPresent()) {
				codUsuario=idUsuarioParam.get();
				if(!codUsuario.toUpperCase().startsWith("VYG")) {
					CandidatoDto candidato=candidatoBussines.getCandidato(codUsuario);
					model.addAttribute("candidato", candidato);
					isCandidato= true;
				 }
			}else {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				UserDetail usuario = (UserDetail) authentication.getPrincipal();
				codUsuario=usuario.getId();
			}
			UsuarioDto usuario=   usuarioBussines.getUsuario(codUsuario);
			model.addAttribute("userInfo", usuario);
			model.addAttribute("escandidato", isCandidato);
			return "pages/administracion/perfil/miPerfil";
		}
	
	}
	
