/*
 * Title        : Spring MVC Configuration File 
 * Author       : Getha Jagannathan
 * Date Created : 11/1/2015
 * Description  : Spring MVC configuration using Bean Annotation. 
 * Date Modified: 12/11/2015
 * Modified By  : Getha Jagannathan
 */

package net.getha.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import net.getha.spring.dao.ContactDAO;
import net.getha.spring.dao.ContactDAOImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@Configuration
@ComponentScan(basePackages="net.getha.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter
{
	// View Resolver - JSP files
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	// Add Style, image resources
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
    //Configure MySql Database connectivity
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("********");
		return dataSource;
	}
	//Configure Mail Server
	@Bean
	public Properties javaMailProperties(){
	    Properties properties = new Properties();
	    properties.put("mail.transport.protocol", "smtp");
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.debug", "true");
	    return properties;
	}
	@Bean
	public JavaMailSenderImpl mailSender() {
	    JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
	    javaMailSenderImpl.setHost("smtp.gmail.com");
	    javaMailSenderImpl.setPort(587);
	    javaMailSenderImpl.setUsername("user@mail.com");
	    javaMailSenderImpl.setPassword("password");
	    javaMailSenderImpl.setJavaMailProperties(javaMailProperties());
	    return javaMailSenderImpl;
	}
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}
}
