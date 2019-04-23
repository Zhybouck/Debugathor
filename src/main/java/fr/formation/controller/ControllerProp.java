package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.dao.IPropositionDAO;
import fr.formation.dao.ISolutionDAO;
import fr.formation.entities.Proposition;
import fr.formation.entities.Solution;

@Controller
@Transactional
@RequestMapping("/Commentaires")
public class ControllerProp {

	@Autowired
	 IPropositionDAO propserv;
	
	@Autowired
	ISolutionDAO solserv;
	
	@RequestMapping(value="/AllForOne", method = RequestMethod.GET)
	public String init(@ModelAttribute("Id") Long id, Model model) {
		Solution sol = solserv.findById(id);
		List<Proposition> list = propserv.findAllPropbySolution(sol);
		model.addAttribute("AllProp", list);
		return "PropForOne";
	}
	
	
}
