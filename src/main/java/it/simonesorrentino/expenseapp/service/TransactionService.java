package it.simonesorrentino.expenseapp.service;

import java.util.List;

import it.simonesorrentino.expenseapp.model.Account;
import it.simonesorrentino.expenseapp.model.Category;
import it.simonesorrentino.expenseapp.model.Transaction;

public interface TransactionService {
	
	List<Transaction> getAll();
	Transaction getTransaction(long id);
	List<Transaction> getTransactionByAccountTo(Account accountTo);
	List<Transaction> getTransactionByAccountFrom(Account accountFrom);
	List<Transaction> getTransactionByCategory(Category category);
	Transaction addUpdateTransaction(Transaction transaction);
	List<Transaction> deleteTransaction(Transaction transaction);
	List<Transaction> deleteAllTransaction();

}
