package fr.formation.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.config.ApplicationContextConfig;
import fr.formation.config.SpringWebAppInitializer;
import fr.formation.entities.Logiciel;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={ApplicationContextConfig.class,SpringWebAppInitializer.class})
@Transactional
public class LogicielDAOTest {
	
	@Autowired
	private ILogicielDAO logicielDAO;
	
	@Test
	@Rollback(true)
	public void saveLogiciel() {
		Logiciel log = new Logiciel();
		log.setIdLogiciel(888l);
		log.setNomLogiciel("test");
		log.setVersion("v12.3");
		logicielDAO.save(log);
		List<Logiciel> logs=logicielDAO.getAll();
		
		assertEquals(logs.size(),4);
	}
	
	@Test
	@Rollback(true)
	public void updateLogiciel() {
		Logiciel log = logicielDAO.findById(3l);
		log.setNomLogiciel("test");
		log.setVersion("v22222");
		logicielDAO.update(log);
		List<Logiciel> logs=logicielDAO.getAll();
		
		assertEquals(logs.size(),3);
		assertEquals(logicielDAO.findById(3l),log);
	}
	
	@Test
	@Rollback(true)
	public void deleteLogiciel() {
		Logiciel log = new Logiciel();
		log.setIdLogiciel(888l);
		log.setNomLogiciel("test");
		log.setVersion("v12.3");
		logicielDAO.save(log);
		logicielDAO.delete(log);
		List<Logiciel> logs=logicielDAO.getAll();
		System.out.println(logs.size());
		
		assertEquals(logs.size(),3);
	}
	
	@Test
	public void findByName(){
		List<Logiciel> logs=logicielDAO.findByName("eclipse");
		assertNotNull(logs);
		assertEquals(logs.size(), 2);
	}
}
