package fr.formation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import fr.formation.cryptlogin.LoginUtils;
import fr.formation.entities.Utilisateur;
import fr.formation.services.IUtilisateurService;

@Controller
@Transactional
@RequestMapping("/user")
public class ControllerUtil {
	private static final Log log = LogFactory.getLog(ControllerUtil.class);

	@Autowired
	IUtilisateurService service;

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String initView(Model model, HttpSession session, HttpServletRequest request) {
		log.info("-------------------------Initialisation des utilisateurs controlleurs---------------------");
		if (null != request.getSession().getAttribute("Utilisateur")) {
			return "redirect:/Solution/init";
		}
		session.setAttribute("Utilisateur", null);
		model.addAttribute("userform", new Utilisateur());
		
		return "login";
	}

	@RequestMapping(value = "/id", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("userform") Utilisateur utilisateur, BindingResult result, Model model,
			HttpSession session) {
		log.info("-------------------------Login---------------------");

		
		if (utilisateur.getMail().equals(null)) {
			log.info("-------------------------L'utilisateur est null---------------------");

			return "redirect:/user/init";
		} else {
			log.info("-------------------------L'utilisateur est pas null---------------------");
			log.info("-------------------------Creation du checkeur---------------------");
			Utilisateur checkeur = service.getbyMail(utilisateur.getMail());
			log.info("-------------------------Creation du Checkeur de l'utilisateur---------------------");

			if ((utilisateur.getMail().equals(checkeur.getMail()))) {
				log.info("-------------------------Cryptage mdp---------------------");

				String hashed_mdp = LoginUtils.hashPassword(utilisateur.getMdp());
				if (LoginUtils.checkmdp(utilisateur.getMdp(), checkeur.getMdp())) {
					session.setAttribute("Utilisateur", checkeur);
					return "redirect:/Solution/init";
				} else {
					return "login";
				}
			} else {
				return "login";
			}
		}
	}

	@RequestMapping(value = "/addone", method = RequestMethod.POST)
	public String addUser(Model model) {
		model.addAttribute("creationutilisateur", new Utilisateur());
		System.out.println("Je passe par addone");
		return "inscription";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("creationutilisateur") Utilisateur crea, BindingResult result,
			Model model) {
		System.out.println("Je passe par add");

		java.util.Date date = new java.util.Date();
		java.sql.Date d = new java.sql.Date(date.getTime());
		System.out.println(crea.getMail());
//		Utilisateur exist = service.getbyMail(crea.getMail());
//		if (null != exist) {
//			System.out.println("hey?");
			if (crea.equals(null)) {
				System.out.println("creation nulle");
				return "inscription";
			} else {
				if (result.hasErrors()) {
					System.out.println("result has error");
					return "inscription";
				} else {
					System.out.println("J'ai tout passé utilisateur créé");

					System.out.println("else");
					crea.setDateInsc(d);
					crea.setMdp(LoginUtils.hashPassword(crea.getMdp()));
					service.save(crea);
					return "redirect:/user/init";
				}
			}
//		} else {
//			System.out.println("j'ai foiré maggle");
//
//			return "inscription";
//		}
	}

	@RequestMapping(value = "/disconnect", method = RequestMethod.POST)
	public String endSessionHandlingMethod(SessionStatus status, HttpSession session) {
		session.invalidate();
		return "login";
	}

}
