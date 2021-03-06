package it.simonesorrentino.expenseapp.service;

import java.util.List;

import it.simonesorrentino.expenseapp.model.Account;

public interface AccountService {
	
	List<Account> getAll();
	Account getAccount(long id);
	Account addUpdateAccount(Account account);
	List<Account> deleteAccount(Account account);
	List<Account> deleteAllAccount();
	Account getAccountByName(String name);

}
