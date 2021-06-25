package com.cmc.gestion.talento.web.controller;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class IndexController {
	
	 @GetMapping({"/","/home"})
	    public String main(Model model) {
	        return "pages/index";
	    }
	 
	 @GetMapping("/tabla")
	    public String main2(Model model) {
	        return "pages/ejemplos/dataTable";
	    }
	 
	 @GetMapping("/form")
	    public String form(Model model) {
	        return "pages/ejemplos/formulario";
	    }
	 
	 @GetMapping(value = "/data",produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody Object getData() {
		  Resource resource = new ClassPathResource("/static/data/ejemplo.json");
	        try {
	            ObjectMapper mapper = new ObjectMapper();
	            System.out.println(resource.getInputStream());
	            return mapper.readValue(resource.getInputStream(), Object.class);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }catch (Exception e) {
	        	e.printStackTrace();
	       
	    }
	        return null;
	 }
	 
	 @GetMapping("/pagina1")
	    public String pagina1(Model model) {
	        return "pages/pagina1";
	    }
	 


}
