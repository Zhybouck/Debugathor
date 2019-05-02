package fr.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.formation.dao.ILogicielDAO;
import fr.formation.entities.Logiciel;

@Service
public class LogicielService implements ILogicielService{
	
	@Autowired
	@Qualifier(value="logicielDao")
	ILogicielDAO logDao;
	
	public LogicielService() {
	}
	
	
	@Override
	public void save(Logiciel obj) {
		logDao.save(obj);
		
	}

	@Override
	public void update(Logiciel obj) {
		logDao.update(obj);
		
	}

	@Override
	public void delete(Logiciel obj) {
		logDao.delete(obj);
		
	}

	@Override
	public Logiciel findById(Long empId) {
		return logDao.findById(empId);
	}
	
	@Override
	public List<Logiciel> getAll() {
		return logDao.getAll();
	}

	/*
	 * recupère une liste de logiciels en fonction de son nom
	 */
	@Override
	public List<Logiciel> findByName(String name) {
		return logDao.findByName(name);
	}

}
