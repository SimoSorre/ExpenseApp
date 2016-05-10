package it.simonesorrentino.expenseapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.simonesorrentino.expenseapp.model.Account;
import it.simonesorrentino.expenseapp.model.Total;
import it.simonesorrentino.expenseapp.service.AccountService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private AccountService as;
	
	
	@RequestMapping
	public ResponseEntity<Object> getTotal(){
		final String methodName = "getTotal";
		logger.info(methodName);
		
		List<Account> conti = as.getAll();
		Double totale = new Double(0);
		Total tot = new Total();
		for(Account conto : conti){
			if(conto.isIncludeInTotal())
				totale += conto.getBalance();
			tot.setTotal(totale);
			tot.setAccountId(conto.getId());
			tot.setCurrency(conto.getCurrency());
			
		}
		return new ResponseEntity<Object> (tot, HttpStatus.OK);
	}
	
}
