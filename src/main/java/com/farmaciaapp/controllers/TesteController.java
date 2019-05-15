package com.farmaciaapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesteController {

	@RequestMapping("/edu")
	public String teste(){
		return "index";		
	}
	
}

