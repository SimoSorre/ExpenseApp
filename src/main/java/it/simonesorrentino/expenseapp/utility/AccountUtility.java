package it.simonesorrentino.expenseapp.utility;

import java.util.Currency;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.simonesorrentino.expenseapp.model.Account;

public class AccountUtility {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountUtility.class);

	public static Account fillObject(JSONObject jsonAccount){
		Account account = new Account();
		
		return fillObject(jsonAccount, account);
		
		
	}
	
	public static Account fillObject(JSONObject jsonAccount, Account account){
		
		account.setAttivo(jsonAccount.getBoolean("attivo"));
		account.setIncludeInTotal(jsonAccount.getBoolean("includeInTotal"));
		account.setBalance(jsonAccount.getDouble("balance"));
		
		if(jsonAccount.get("currency")!=null && Currency.getAvailableCurrencies().contains(Currency.getInstance(jsonAccount.getString("currency")))){
			account.setCurrency(Currency.getInstance((String)jsonAccount.get("currency")));
		}
		account.setName(jsonAccount.getString("name"));
		
		return account;
		
	}
	
}
