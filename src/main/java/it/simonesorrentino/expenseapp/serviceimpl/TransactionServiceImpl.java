package it.simonesorrentino.expenseapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.simonesorrentino.expenseapp.model.Transaction;
import it.simonesorrentino.expenseapp.repository.TransactionRepository;
import it.simonesorrentino.expenseapp.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository tr;
	
	@Override
	public List<Transaction> getAll() {
		return tr.findAll();
	}

	@Override
	public Transaction getTransaction(long id) {
		return tr.findById(id);
	}

	@Override
	public Transaction getTransactionByAccountTo(String accountTo) {
		return tr.findByAccountTo(accountTo);
	}

	@Override
	public Transaction getTransactionByAccountFrom(String accountFrom) {
		return tr.findByAccountFrom(accountFrom);
	}

	@Override
	public Transaction getTransactionByCategory(String category) {
		return tr.findByCategory(category);
	}

	@Override
	public Transaction addUpdateTransaction(Transaction transaction) {
		return tr.save(transaction);
	}

	@Override
	public List<Transaction> deleteTransaction(Transaction transaction) {
		tr.delete(transaction);
		return tr.findAll();
	}

	@Override
	public List<Transaction> deleteAllTransaction() {
		tr.deleteAll();
		return tr.findAll();
	}

}
