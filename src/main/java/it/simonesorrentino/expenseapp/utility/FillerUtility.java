package it.simonesorrentino.expenseapp.utility;

import java.io.IOException;
import java.util.Date;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.simonesorrentino.expenseapp.model.Account;
import it.simonesorrentino.expenseapp.model.Category;
import it.simonesorrentino.expenseapp.model.Transaction;

public class FillerUtility {
	
	private static final Logger logger = LoggerFactory.getLogger(FillerUtility.class);

	public static Account fillAccount(JSONObject jsonAccount) throws JsonParseException, JsonMappingException, IOException{
		Account account = new ObjectMapper().readValue(jsonAccount.toString(), Account.class);
		
		return account;
	}
	
	public static Account fillAccount(JSONObject jsonAccount, Account account) throws JsonProcessingException, IOException{
		
		account = new ObjectMapper().readerForUpdating(account).readValue(jsonAccount.toString());
		
		return account;
		
	}
	
	public static Transaction fillTransaction(JSONObject jsonTransaction) throws JsonParseException, JsonMappingException, IOException{
		Transaction transaction = new ObjectMapper().readValue(jsonTransaction.toString(), Transaction.class);
		if(transaction.getDate()==null){
			transaction.setDate(new Date());
		}
		return transaction;
	}
	
	public static Transaction fillTransaction(JSONObject jsonTransaction, Transaction transaction) throws JsonProcessingException, IOException{
		transaction = new ObjectMapper().readerForUpdating(transaction).readValue(jsonTransaction.toString());
		
		return transaction;
	}
	
	public static Category fillCategory(JSONObject jsonCategory) throws JsonParseException, JsonMappingException, IOException{
		Category category = new ObjectMapper().readValue(jsonCategory.toString(), Category.class);
		
		return category;
	}
	
	public static Category fillCategory(JSONObject jsonCategory, Category category) throws JsonProcessingException, IOException{
		category = new ObjectMapper().readerForUpdating(category).readValue(jsonCategory.toString());
		
		return category;
	}

	
}
