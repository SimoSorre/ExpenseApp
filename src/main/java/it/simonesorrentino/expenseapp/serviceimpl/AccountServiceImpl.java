package it.simonesorrentino.expenseapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.simonesorrentino.expenseapp.model.Account;
import it.simonesorrentino.expenseapp.repository.AccountRepository;
import it.simonesorrentino.expenseapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccount(long id) {
		return accountRepository.findById(id);
	}

	@Override
	public Account addUpdateAccount(Account account) {
		return accountRepository.save(account);
	}

}
