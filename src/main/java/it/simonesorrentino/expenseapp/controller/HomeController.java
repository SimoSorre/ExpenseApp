package it.simonesorrentino.expenseapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.simonesorrentino.expenseapp.model.Message;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		String pippo = "Ciao Pippo";
		
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("testString", pippo);
		
		return "home";
	}
	
	
	/*Inizio parte Rest*/
	
	@RequestMapping(value = "rest/{name}")
	public @ResponseBody Message getMessage(@PathVariable String name){
		Message msg = new Message(name, "Hello "+name);
		
		return msg;
	}
	
}
