package it.simonesorrentino.expenseapp.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import it.simonesorrentino.expenseapp.enums.Currency;
import it.simonesorrentino.expenseapp.model.Account;
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
		Double num = -12.2;
		Double num2 = 10.5;
		Double sum = num + num2;
		NumberFormat nf = new DecimalFormat("#0.00");
		String numero = nf.format(sum);
		Currency c = Currency.getInstance(locale);
		
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("testString", pippo);
		model.addAttribute("numeroNegativo",numero);
		model.addAttribute("valuta",c);
		
		return "home";
	}
	
	
	/*Inizio parte Rest*/
	
	@RequestMapping(value = "rest/{name}")
	public @ResponseBody Message getMessage(@PathVariable String name){
		Message msg = new Message(name, "Hello "+name);
		
		return msg;
	}
	
	@RequestMapping(value ="rest/accounts")
	public @ResponseBody List<Account> getAccounts(Locale locale){
		NumberFormat nf = new DecimalFormat("#0.00");
		List<Account> conti = new ArrayList<Account>();
		Account a = new Account("1", Currency.getInstance(locale), "Conto Corrente", nf.format(0), true);
		Account a2 = new Account("1", Currency.getInstance(locale), "Genius", nf.format(0), true);
		conti.add(a);
		conti.add(a2);
		
		return conti;
	}
	
}
