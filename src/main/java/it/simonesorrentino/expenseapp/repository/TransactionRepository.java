package it.simonesorrentino.expenseapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.simonesorrentino.expenseapp.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	@Override
	List<Transaction> findAll();
	Transaction findById(long id);
	Transaction findByCategory(String category);
	Transaction findByAccountFrom(String accountFrom);
	Transaction findByAccountTo(String accountTo);
	
	Transaction save(Transaction transaction);
	
	@Override
	void delete(Transaction transaction);
	void deleteAll();
	
}
