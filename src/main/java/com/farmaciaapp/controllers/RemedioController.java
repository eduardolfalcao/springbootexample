package com.farmaciaapp.controllers;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.farmaciaapp.models.Remedio;

@Controller
public class RemedioController {
	
//	@Autowired
//	private RemedioRepository rr;
	
	@Autowired
	private CrudRepository<Remedio,String> rr;
	
	@RequestMapping(value="/cadastrarRemedio", method=RequestMethod.GET)
	public String form(){
		return "remedio/formRemedio";
	}

	@RequestMapping(value="/cadastrarRemedio", method=RequestMethod.POST)
	public String form(Remedio remedio){		
		rr.save(remedio);		
		return "redirect:/cadastrarRemedio";
	}
	
	@RequestMapping(value="/listarRemedios", method=RequestMethod.GET)
	public ModelAndView listarRemedios(){
		ModelAndView mv = new ModelAndView("index");
		Iterable<Remedio> remedios =  rr.findAll();
		mv.addObject("remedios", remedios);
		return mv;
	}
	
}