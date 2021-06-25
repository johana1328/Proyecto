package com.cmc.gestion.talento.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public abstract class AbstractBaseController<T> {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	abstract String GetViewName();
	abstract List<T> getlistObjetRender(); 
	
	 @GetMapping
	 final ModelAndView getModelAndView() {
		 logger.debug("Ingresando a pagina por defecto "+GetViewName());
		 ModelAndView model = new ModelAndView();
		 List<T> results=  getlistObjetRender(); 
		 if(results != null) {
			 logger.debug("Se renderiza pagina con informacion OK");
			 model.addObject("data", results);
		 }
		 model.setViewName(GetViewName());
		 return model;
	 }
}
