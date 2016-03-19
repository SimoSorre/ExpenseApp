package it.simonesorrentino.expenseapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.simonesorrentino.expenseapp.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	@Override
	List<Account> findAll();
	Account findById(long id);
	Account save(Account account);
	@Override
	void delete(Account account);
	void deleteAll();
	
	
}
