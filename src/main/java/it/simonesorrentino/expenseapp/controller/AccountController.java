package it.simonesorrentino.expenseapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

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
import it.simonesorrentino.expenseapp.service.AccountService;
import it.simonesorrentino.expenseapp.utility.FillerUtility;
import it.simonesorrentino.expenseapp.utility.JsonUtility;

@RestController
@RequestMapping("accounts")
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;

	/*GET*/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAllAccounts(){
		final String methodName = "getAllAccounts";
		logger.info(methodName);
		
		List<Account> accountList = accountService.getAll();
		logger.info(accountList.toString());
		
		if(accountList.isEmpty()){
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<Object> (accountList, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAccount( @PathVariable("id") long id){
		final String methodName="getAccount";
		logger.info(methodName);
		
		return new ResponseEntity<Object> (accountService.getAccount(id), HttpStatus.OK );
	}
	
	@RequestMapping(value="name/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByName(@PathVariable("name") String name){
		final String methodName="getByName";
		logger.info(methodName);
		
		return new ResponseEntity<Object> (accountService.getAccountByName(name), HttpStatus.OK );
	}
	
	@RequestMapping(value="total", method = RequestMethod.GET)
	public ResponseEntity<Object> getTotalAccount(){
		final String methodName="getTotalAccount";
		logger.info(methodName);
		
		List<Account> all = accountService.getAll();
		Double total = 0.0;
		
		for(Account a : all){
			total += a.getBalance();
		}
		
		return new ResponseEntity<Object> (total, HttpStatus.OK);
	}
	/*Fine GET*/
	
	
	/*POST*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addAccount(HttpServletRequest request){
		final String methodName = "addAccount";
		logger.info(methodName);
		
		JSONObject jsonAccount = JsonUtility.returnJson(request);

		Account account = null;
		try {
			account = FillerUtility.fillAccount(jsonAccount);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		accountService.addUpdateAccount(account);
		logger.info(account.toString());
		
		return new ResponseEntity<Object>(account, HttpStatus.OK);
	}
	/*Fine POST*/
	
	/*PUT*/
	@RequestMapping(value="{id}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateAccount(@PathVariable("id") long id, HttpServletRequest request){
		final String methodName="updateAccount";
		logger.info(methodName);
		
		JSONObject jsonAccount = JsonUtility.returnJson(request);
		
		Account account = null;
		try {
			account = FillerUtility.fillAccount(jsonAccount, accountService.getAccount(id));
			logger.info(account.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(accountService.addUpdateAccount(account) , HttpStatus.OK);
	}
	/*Fine PUT*/
	
	/*DELETE*/
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAccount(@PathVariable("id") long id ){
		final String methodName="deleteAccount";
		logger.info(methodName);
		
		Account account = accountService.getAccount(id);
		accountService.deleteAccount(account);
		List<Account> accountList = accountService.getAll();
		
		return new ResponseEntity<Object> (accountList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAllAccount(){
		final String methodName="deleteAccount";
		logger.info(methodName);
		
		accountService.deleteAllAccount();
		List<Account> accountList = accountService.getAll();
		
		return new ResponseEntity<Object> (accountList, HttpStatus.OK);
	}
	/*Fine DELETE*/
}
