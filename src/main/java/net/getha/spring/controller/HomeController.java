/*
 * Title        : Spring MVC Controller
 * Author       : Getha Jagannathan
 * Date Created : 11/1/2015
 * Description  : Spring MVC Controller implementing mapping of requests from the view. 
 * Date Modified: 12/11/2015
 * Modified By  : Getha Jagannathan
 *
 */
package net.getha.spring.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.getha.spring.dao.ContactDAO;
import net.getha.spring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;



@Controller
public class HomeController {

	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private JavaMailSender mailSender;	
	
	@ModelAttribute("countryList")
	public List<String> getCountry()
	{
		List<String> countryList = new ArrayList<String>();
		List<Contact> listContact = contactDAO.list();
		for(Contact s : listContact)
		{
			countryList.add(s.getEmail());
		}
		return countryList;
	}
	
	//Home Screen
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("home");	
		return model;
	}
	//Home Screen
		@RequestMapping(value="/home")
		public ModelAndView home(ModelAndView model) throws IOException{
			List<Contact> listContact = contactDAO.list();
			model.addObject("listContact", listContact);
			Contact newContact = new Contact();
			model.addObject("contact", newContact);
			model.setViewName("home");
			return model;
		}
	// Click Add new student from the home page - redirects to the ContactForm page
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("ContactForm");
		return model;
	}
	// Click Send Email from the home page - redirect to the SendEmail page
	@RequestMapping(value = "/emailContact", method = RequestMethod.GET)
	public ModelAndView emailContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("emailForm");
		return model;
	}
	//Click on Send button on the Send Email page - redirects to home page
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ModelAndView sendEmail(HttpServletRequest request) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(request.getParameter("country"));
		email.setSubject(request.getParameter("subject"));
		email.setText(request.getParameter("message"));
		// sends the e-mail
		mailSender.send(email);
		return new ModelAndView("redirect:/");
		
	}
	//Export contacts to the excel spreadsheet
	@RequestMapping(value = "/createExcel", method = RequestMethod.GET)
	public ModelAndView createExcel(ModelAndView model) throws IOException {
		List<Contact> listContact = contactDAO.list();
		Workbook  workbook = new HSSFWorkbook();
		HSSFSheet sheet = (HSSFSheet) workbook.createSheet("new sheet");
		HSSFRow header = (HSSFRow) sheet.createRow(0);
		header.createCell(0).setCellValue("Month");
		header.createCell(1).setCellValue("Revenue");
		
		int rowNum = 1;
		for(Contact s : listContact)
		{
			//create the row data
			HSSFRow row = (HSSFRow) sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getName());
			row.createCell(1).setCellValue(s.getEmail());
         }
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\me\\Documents\\workbook.xls");
		workbook.write(fileOut);
	    fileOut.close();
	    return new ModelAndView("Export");
	}
	// Click on Save button on the ContactForm - Redirects to the home page
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		contactDAO.saveOrUpdate(contact);	
		return new ModelAndView("redirect:/");
	}
	// Click on Cancel button on the ContactForm - Redirects to the home page
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public ModelAndView cancel(HttpServletRequest request) {		
		return new ModelAndView("redirect:/");
	}
	// Click on Delete link on the home page - Deletes Student record and redirects to home page
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactDAO.delete(contactId);
		return new ModelAndView("redirect:/");
	}
	// Click on Edit link on the home page - Edits Student record and redirects to the home page
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(contactId);
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("contact", contact);
		return model;
	}
}
