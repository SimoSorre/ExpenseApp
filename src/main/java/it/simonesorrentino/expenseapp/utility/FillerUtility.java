package it.simonesorrentino.expenseapp.utility;

import java.util.Currency;
import java.util.Iterator;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.simonesorrentino.expenseapp.model.Account;

public class FillerUtility {
	
	private static final Logger logger = LoggerFactory.getLogger(FillerUtility.class);

	public static Account fillAccount(JSONObject jsonAccount){
		Account account = new Account();
		
		return fillAccount(jsonAccount, account);
		
		
	}
	
	public static Account fillAccount(JSONObject jsonAccount, Account account){
		
		@SuppressWarnings("rawtypes")
		Iterator key = jsonAccount.keys();
		
		while(key.hasNext()){
			switch (String.valueOf(key.next())){
				case "attivo":
					account.setAttivo(jsonAccount.getBoolean("attivo"));
					break;
				case "includeInTotal":
					account.setIncludeInTotal(jsonAccount.getBoolean("includeInTotal"));
					break;
				case "balance":
					account.setBalance(jsonAccount.getDouble("balance"));
					break;
				case "currency":
					Currency currency = Currency.getInstance(jsonAccount.getString("currency"));
					if(jsonAccount.get("currency")!=null && Currency.getAvailableCurrencies().contains(currency)){
						account.setCurrency(Currency.getInstance((String)jsonAccount.get("currency")));
					}
					break;
				case "name":
					account.setName(jsonAccount.getString("name"));
					break;
			}
			
		}
		
		return account;
		
	}
	
}
