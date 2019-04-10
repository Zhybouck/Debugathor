package fr.formation.controller;

import fr.formation.dao.ILogicielDAO;
import fr.formation.dao.LogicielDAO;
import fr.formation.entities.Logiciel;

public class ControllerLogiciel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ILogicielDAO dao= new LogicielDAO();
		Logiciel l = dao.findById(1);
		System.out.println(l);
	}
	
}
