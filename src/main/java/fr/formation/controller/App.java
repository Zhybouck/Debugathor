package fr.formation.controller;

import fr.formation.beans.Logiciel;
import fr.formation.dao.ILogicielDAO;
import fr.formation.dao.LogicielHome;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ILogicielDAO dao= new LogicielHome();
		Logiciel l = dao.findById(1);
		System.out.println(l);
	}
	
}
