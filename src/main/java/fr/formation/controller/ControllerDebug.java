package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.entities.Logiciel;
import fr.formation.services.ILogicielService;

@Controller
@Transactional
public class ControllerDebug {
	
	@Autowired
	ILogicielService service;

	@RequestMapping("/test")
	public String sendAllLogiciel(Model model) {
		
		List<Logiciel> list=service.getAll();
		Logiciel log=service.findById(2l);
		model.addAttribute("list",list);
		return "debug";
	}
}
