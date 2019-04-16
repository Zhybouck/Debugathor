package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import fr.formation.dao.IUtilisateurDAO;
import fr.formation.dao.UtilisateurDAO;
import fr.formation.entities.Utilisateur;

@Controller
public class ControlPanel {

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String initView(Model model) {
		model.addAttribute("userform", new Utilisateur());
		return "Accueil";
	}

	// Envoyé ici suite à l'écran de connexion, sert à vérifier que l'utilisateur
	// existe
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("userform") Utilisateur utilisateur, BindingResult result) {

		IUtilisateurDAO dao = new UtilisateurDAO();
		String mail = utilisateur.getMail();
		Utilisateur checkeur = dao.getByMail(mail);

		if ((utilisateur.getMail().equals(checkeur.getMail()) && (utilisateur.getMdp().equals(checkeur.getMdp())))){
//			SessionFactory.setAttribute("userco", utilisateur);
			return "Tableau";
		} else {
			return "Accueil";
		} 
	}

	@RequestMapping(value = "/disconnect", method = RequestMethod.POST)
	public String disconnect(@ModelAttribute("userform") Utilisateur utilisateur, BindingResult result) {
		
		return "Accueil";

	}
}
