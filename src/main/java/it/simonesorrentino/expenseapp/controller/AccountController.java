package it.simonesorrentino.expenseapp.controller;

import java.util.ArrayList;
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
import it.simonesorrentino.expenseapp.service.AccountService;
import it.simonesorrentino.expenseapp.utility.AccountUtility;
import it.simonesorrentino.expenseapp.utility.JsonUtility;

@RestController
@RequestMapping("accounts")
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAllAccounts(){
		final String methodName = "getAllAccounts";
		logger.info(methodName);
		
		List<Account> accountList = accountService.getAll();
		
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addAccount(HttpServletRequest request){
		final String methodName = "addAccount";
		logger.info(methodName);
		
		JSONObject jsonAccount = JsonUtility.returnJson(request);

		Account account = AccountUtility.fillAccountObject(jsonAccount);
		
		accountService.addUpdateAccount(account);
		
		return new ResponseEntity<Object>(account, HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateAccount(@PathVariable("id") long id, HttpServletRequest request){
		final String methodName="updateAccount";
		logger.info(methodName);
		
		JSONObject jsonAccount = JsonUtility.returnJson(request);
		
		Account account = AccountUtility.fillAccountObject(jsonAccount, accountService.getAccount(id));
		
		return new ResponseEntity<Object>(accountService.addUpdateAccount(account) , HttpStatus.OK);
	}
	
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
 	
}
