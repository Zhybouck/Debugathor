package fr.formation.config;
 
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import fr.formation.interceptor.SessionInterceptor;
 
@Configuration
@ComponentScan("fr.formation.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:ds-hibernate-cfg.properties")
public class ApplicationContextConfig {
 
 // The Environment class serves as the property holder
 // and stores all the properties loaded by the @PropertySource
 @Autowired
 private Environment env;
 
 
 
 @Bean
 public ResourceBundleMessageSource messageSource() {
     ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
     // Load property in message/validator.properties
     rb.setBasenames(new String[] { "messages/validator"});
     return rb;
 }
 
 
 @Bean(name = "viewResolver")
 public InternalResourceViewResolver getViewResolver() {
     InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
     viewResolver.setPrefix("/WEB-INF/pages/");
     viewResolver.setSuffix(".jsp");
     return viewResolver;
 }
 
 @Bean(name = "dataSource")
 public DataSource getDataSource() {
     DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
     dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
     dataSource.setUrl(env.getProperty("ds.url"));
     dataSource.setUsername(env.getProperty("ds.username"));
     dataSource.setPassword(env.getProperty("ds.password"));
 
     return dataSource;
 }
 
 @Autowired
 @Bean(name = "sessionFactory")
 public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
     Properties properties = new Properties();
    
     // See: ds-hibernate-cfg.properties
     properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
     properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
     properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
//     properties.put("hibernate.connection.useUnicode", env.getProperty("hibernate.connection.useUnicode"));
//     properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
//     properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
//     properties.put("current_session_context_class", env.getProperty("current_session_context_class"));
//     <property name="hibernate.connection.CharSet">utf8</property>
//     <property name="hibernate.connection.characterEncoding">utf8</property>
//     <property name="hibernate.connection.useUnicode">true</property>
      
 
     LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
     factoryBean.setPackagesToScan(new String[] { "fr.formation.entities" });
     factoryBean.setDataSource(dataSource);
     factoryBean.setHibernateProperties(properties);
     factoryBean.afterPropertiesSet();
     //
     SessionFactory sf = factoryBean.getObject();
     return sf;
 }
 
 @Autowired
 @Bean(name = "transactionManager")
 public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
     HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
     return transactionManager;
 }
 
// @Autowired
// @Bean(name = "SessionInterceptor")
// SessionInterceptor sessionInterceptor() {
//     return new SessionInterceptor();
//}
 
// @Bean(name = "applicantDAO")
// public ApplicantDAO getApplicantDAO() {
//     return new ApplicantDAOImpl();
// }
 
}