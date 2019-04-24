package fr.formation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fr.formation.entities.Utilisateur;
import fr.formation.services.IUtilisateurService;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {
	private static final Log log = LogFactory.getLog(SessionInterceptor.class);

//	@Autowired
//	IUtilisateurService service;
//	private HttpSession session;

	@Autowired
	HttpSession session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Pre Handle");
		System.out.println(request.getServletPath());
		if (request.getServletPath().equals("/user/init") || request.getServletPath().equals("/user/id")
				|| request.getServletPath().equals("/user/addone") || request.getServletPath().equals("/user/add")) {
			log.info("-------------------------Initialisation des utilisateurs---------------------");
			System.out.println("Je suis dans le premier if");
			return true;
		}
		if (null != request.getSession().getAttribute("Utilisateur")) {
			System.out.println("Je suis dans le deuxieme if");
			log.info(
					"-----------------------------------------La Session Existe---------------------------------------");
			return true;
		}
		log.info(
				"-------------------------La Session N'existe pas ou l'URL n'est pas autorisée sans session---------------------");
		System.out.println("Je suis dans aucun if");

		response.sendRedirect(request.getContextPath());
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
