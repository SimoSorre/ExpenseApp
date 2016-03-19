package it.simonesorrentino.expenseapp.service;

import java.util.List;

import it.simonesorrentino.expenseapp.model.Account;

public interface AccountService {
	
	List<Account> getAll();
	Account getAccount(long id);
	Account addUpdateAccount(Account account);

}
