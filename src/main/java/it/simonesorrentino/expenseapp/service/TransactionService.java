package it.simonesorrentino.expenseapp.service;

import java.util.List;

import it.simonesorrentino.expenseapp.model.Transaction;

public interface TransactionService {
	
	List<Transaction> getAll();
	Transaction getTransaction(long id);
	Transaction getTransactionByAccountTo(String accountTo);
	Transaction getTransactionByAccountFrom(String accountFrom);
	Transaction getTransactionByCategory(String category);
	Transaction addUpdateTransaction(Transaction transaction);
	List<Transaction> deleteTransaction(Transaction transaction);
	List<Transaction> deleteAllTransaction();

}
