package com.cmc.gestion.talento.web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArqErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest req, Model model ) {
		Object status= req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null) {
			int statusCode= Integer.parseInt(status.toString());
			switch (statusCode) {
			case 500:
				return "errors/error500";
			case 403:
				return "errors/error403";
			case 404:
				return "errors/error404";
			}
		}
		return "errors/error500";
	}

}
