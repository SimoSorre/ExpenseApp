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

import it.simonesorrentino.expenseapp.enums.Type;
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
	
	private Account accountTo;
	private Account accontFrom;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllTransactions(){
		final String methodName="getTransaction";
		logger.info(methodName);
		List<Transaction> t = ts.getAll();
		logger.info(t.toString());
		return new ResponseEntity<Object>(t ,HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getTransaction(@PathVariable("id") long id){
		final String methodName="getTransaction";
		logger.info(methodName);
		Transaction t = ts.getTransaction(id);
		logger.info(t.toString());
		return new ResponseEntity<Object>(t ,HttpStatus.OK);
	}
	
	@RequestMapping(value="accountFrom/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByAccountFrom(@PathVariable("name") String name){
		final String methodName="getByAccountFrom";
		logger.info(methodName);
		Account a =as.getAccountByName(name);
		List<Transaction> t = ts.getTransactionByAccountFrom(a);
		logger.info(t.toString());
		return new ResponseEntity<Object> (t, HttpStatus.OK );
	}
	
	@RequestMapping(value="accountTo/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByAccountTo(@PathVariable("name") String name){
		final String methodName="getByAccountTo";
		logger.info(methodName);
		Account a =as.getAccountByName(name);
		List<Transaction> t = ts.getTransactionByAccountTo(a);
		logger.info(t.toString());
		return new ResponseEntity<Object> (t, HttpStatus.OK );
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> addTransaction(HttpServletRequest request){
		final String methodName="addTransaction";
		logger.info(methodName);
		JSONObject jsonTransaction = JsonUtility.returnJson(request);
		recuperaAccount(jsonTransaction);
		Transaction t = null;
		try {
			t = FillerUtility.fillTransaction(jsonTransaction);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		updateAccount(t);
		ts.addUpdateTransaction(t);
		
		return new ResponseEntity<Object>(t,HttpStatus.OK);
	}
	
	
	private void recuperaAccount(JSONObject jsonTransaction) {
		Type tipo = Type.valueOf(jsonTransaction.get("tipo").toString());
		JSONObject jsonAccountTo = null;
		JSONObject jsonAccountFrom = null;
		
		switch (tipo) {
		case INCOME:
			jsonAccountTo = jsonTransaction.getJSONObject("accountTo");
			accountTo = as.getAccount(jsonAccountTo.getLong("id"));
			break;
		case EXPENSE:
			jsonAccountFrom = jsonTransaction.getJSONObject("accountFrom");
			accontFrom = as.getAccount(jsonAccountFrom.getLong("id"));
			break;
		case TRANSFER:
			jsonAccountFrom = jsonTransaction.getJSONObject("accountFrom");
			accontFrom = as.getAccount(jsonAccountFrom.getLong("id"));
			
			jsonAccountTo = jsonTransaction.getJSONObject("accountTo");
			accountTo = as.getAccount(jsonAccountTo.getLong("id"));
			break;
		}
	}

	private void updateAccount(Transaction t){
		
	}

}
