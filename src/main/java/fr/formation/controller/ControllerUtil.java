package fr.formation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.formation.entities.Utilisateur;
import fr.formation.services.IUtilisateurService;

@Controller
@Transactional
@SessionAttributes("userform")
public class ControllerUtil {

	@Autowired
	IUtilisateurService service;

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String initView(Model model) {
		model.addAttribute("userform", new Utilisateur());
		return "Accueil";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("userform") Utilisateur utilisateur, BindingResult result,
			SessionStatus status) {
		String mail = utilisateur.getMail();
		Utilisateur checkeur = service.getbyMail(mail);

		if ((utilisateur.getMail().equals(checkeur.getMail()) && (utilisateur.getMdp().equals(checkeur.getMdp())))) {
			status.isComplete();
			return "Tableau";
		} else {
			return "Accueil";
		}
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("adduser") Utilisateur utilisateur, BindingResult result) {

		if (utilisateur.equals(null)) {
			return "CreaCompte";
		} else {
			if (result.hasErrors()) {
				return "CreaCompte";
			} else {
				service.save(utilisateur);
				return "Tableau";
			}
		}
	}

	@RequestMapping("/disconnect")
	public String endSessionHandlingMethod(SessionStatus status) {
		status.setComplete();
		return "Accueil";
	}

}
