package fr.formation.controller;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Application Lifecycle Listener implementation class ListenerDebugathor
 *
 */
public class ListenerDebugathor implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerDebugathor() {
 
    }

        public final Logger logger = Logger.getLogger("ListenerDebugathor");

        public void contextDestroyed(ServletContextEvent servletContextEvent) {
            SessionFactory sessionFactory = (SessionFactory) servletContextEvent.getServletContext().getAttribute("SessionFactory");
            if(sessionFactory != null && !sessionFactory.isClosed()){
                logger.info("Closing sessionFactory");
                sessionFactory.close();
            }
            logger.info("Released Hibernate sessionFactory resource");
        }

        public void contextInitialized(ServletContextEvent servletContextEvent) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            logger.info("Hibernate Configuration created successfully");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            logger.info("ServiceRegistry created successfully");
            SessionFactory sessionFactory = configuration
                    .buildSessionFactory(serviceRegistry);
            logger.info("SessionFactory created successfully");

            servletContextEvent.getServletContext().setAttribute("SessionFactory", sessionFactory);
            logger.info("Hibernate SessionFactory Configured successfully");
        }
	
}
