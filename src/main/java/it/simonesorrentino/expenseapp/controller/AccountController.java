package it.simonesorrentino.expenseapp.controller;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.simonesorrentino.expenseapp.model.Account;
import it.simonesorrentino.expenseapp.service.AccountService;
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
		List<Account> accountList = new ArrayList<Account>();
		accountList = accountService.getAll();
		
		if(accountList.isEmpty()){
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<Object> (accountList, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addAccount(HttpServletRequest request){
		final String methodName = "addAccount";
		logger.info(methodName);
		Account account = new Account();
		JSONObject jsonAccount = JsonUtility.returnJson(request);
		logger.info(jsonAccount.toString());
		account.setAttivo(jsonAccount.getBoolean("attivo"));
		account.setIncludeInTotal(jsonAccount.getBoolean("includeInTotal"));
		account.setBalance(jsonAccount.getDouble("balance"));
		account.setCurrency(Currency.getInstance((String)jsonAccount.get("currency")));
		account.setName(jsonAccount.getString("name"));
		
		
		
		accountService.addUpdateAccount(account);
		
		return new ResponseEntity<Object>(account, HttpStatus.OK);
	}
	
}
