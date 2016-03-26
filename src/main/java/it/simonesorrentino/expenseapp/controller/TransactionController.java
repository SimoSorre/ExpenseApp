package it.simonesorrentino.expenseapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.simonesorrentino.expenseapp.model.Account;
import it.simonesorrentino.expenseapp.model.Transaction;
import it.simonesorrentino.expenseapp.service.AccountService;
import it.simonesorrentino.expenseapp.service.CategoryService;
import it.simonesorrentino.expenseapp.service.TransactionService;
import it.simonesorrentino.expenseapp.utility.FillerUtility;
import it.simonesorrentino.expenseapp.utility.JsonUtility;

@RestController
@RequestMapping("transactions")
public class TransactionController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private TransactionService ts;
	@Autowired 
	private AccountService as;
	@Autowired
	private CategoryService cs;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllTransactions(){
		
		return new ResponseEntity<Object>(ts.getAll() ,HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getAllTransactions(@PathVariable("id") long id){
		
		return new ResponseEntity<Object>(ts.getTransaction(id) ,HttpStatus.OK);
	}
	
	@RequestMapping(value="accountFrom/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByName(@PathVariable("name") String name){
		final String methodName="getByName";
		logger.info(methodName);
		Account a =as.getAccountByName(name);
		List<Transaction> t = ts.getTransactionByAccountFrom(a);
		
		return new ResponseEntity<Object> (t, HttpStatus.OK );
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> addTransaction(HttpServletRequest request){

		JSONObject jsonTransaction = JsonUtility.returnJson(request);
		
		Transaction t = null;
		try {
			t = FillerUtility.fillTransaction(jsonTransaction);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ts.addUpdateTransaction(t);
		
		return new ResponseEntity<Object>(t,HttpStatus.OK);
	}

}
