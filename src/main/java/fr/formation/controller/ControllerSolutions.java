package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.entities.Solution;
import fr.formation.services.ISolutionService;

@Controller
@Transactional
@RequestMapping("/Solution")
public class ControllerSolutions {
	
	@Autowired
	ISolutionService solserv;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(Model model) {
		List<Solution> liste = solserv.getAll();
		model.addAttribute("listesol", liste);
		return "test2";
	}
	
	
	@RequestMapping(value = "/focus", method = RequestMethod.POST)
	public String focusOnOne(@ModelAttribute("Id")Long Id, Model model) {
		model.addAttribute(solserv.findById(Id));
		return "focusBug";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOne(@ModelAttribute("focusedSol")Solution solution,Model model ,BindingResult result) {
		solserv.update(solution);
		model.addAttribute(solserv.findById((solution).getIdSolution()));
		return "focusBug";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveeOne(@ModelAttribute("addsol")Solution solution,Model model ,BindingResult result) {
		solserv.save(solution);
		
		if(result.hasErrors()) {
			return "addBug";
		}
		model.addAttribute(solserv.findById((solution).getIdSolution()));
		return "focusBug";
	}
	

}
