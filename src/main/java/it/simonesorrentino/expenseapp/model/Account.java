package it.simonesorrentino.expenseapp.model;

import java.util.Currency;
import java.util.List;

public class Account {
	
	private String id;
	private Currency currency;
	private String name;
	private String balance;
	List<Transaction> transactions;
	private boolean includeInTotal;
	
	public Account(){
		super();
	}
	
	public Account(String id, Currency currency, String name, String balance, boolean includeInTotal) {
		super();
		this.id = id;
		this.currency = currency;
		this.name = name;
		this.balance = balance;
		this.includeInTotal = includeInTotal;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public boolean isIncludeInTotal() {
		return includeInTotal;
	}
	public void setIncludeInTotal(boolean includeInTotal) {
		this.includeInTotal = includeInTotal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [id=");
		builder.append(id);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", name=");
		builder.append(name);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", includeInTotal=");
		builder.append(includeInTotal);
		builder.append("]");
		return builder.toString();
	}
	
	

}
