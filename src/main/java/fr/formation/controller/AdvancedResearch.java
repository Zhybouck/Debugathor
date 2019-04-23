package fr.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.entities.Solution;
import fr.formation.services.ISolutionService;

@Controller
@Transactional
@RequestMapping("/Research")
public class AdvancedResearch {

	@Autowired
	ISolutionService solserv;

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("Field", new String());
		return "advresearch";

	}

	@RequestMapping(value = "/advResult", method = RequestMethod.POST)
	public String AdvancedResult(@ModelAttribute("Field") String champ) {
		List<Solution> list = solserv.getAll();
		List<Solution> tribyTitre = new ArrayList();
		List<Solution> tribyType = new ArrayList();
		List<Solution> tribyDate = new ArrayList();

		if (champ.contains("TitreBug")) {
			for (Solution s : list) {
				String t = s.getTitre();
				if (t.equals("TitreBug")) {
					tribyTitre.add(s);
				}
			}
		} if (champ.contains("TypeBug")) {
			for(Solution s: list) {
				if(tri.contains(s)){
					if()
				}
			}
		}

		return "advresult";

	}

}
