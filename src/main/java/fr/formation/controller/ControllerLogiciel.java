package fr.formation.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.dao.ILogicielDAO;
import fr.formation.dao.LogicielDAO;
import fr.formation.entities.Logiciel;
import fr.formation.services.LogicielService;

public class ControllerLogiciel {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LogicielService empserv = (LogicielService) context.getBean("ServiceLogiciel");
		// TODO Auto-generated method stub
		ILogicielDAO dao= new LogicielDAO();
		Logiciel l = dao.findById(1);
		System.out.println(l);
	}
	
}
