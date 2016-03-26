package it.simonesorrentino.expenseapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.simonesorrentino.expenseapp.model.Account;
import it.simonesorrentino.expenseapp.model.Category;
import it.simonesorrentino.expenseapp.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	@Override
	List<Transaction> findAll();
	Transaction findById(long id);
	List<Transaction> findByCategory(Category category);
	List<Transaction> findByAccountFrom(Account accountFrom);
	List<Transaction> findByAccountTo(Account accountTo);
	
	Transaction save(Transaction transaction);
	
	@Override
	void delete(Transaction transaction);
	void deleteAll();
	
	
}
