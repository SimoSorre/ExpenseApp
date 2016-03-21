package it.simonesorrentino.expenseapp.service;

import java.util.List;

import it.simonesorrentino.expenseapp.model.Category;

public interface CategoryService {
	
	List<Category> getAll();
	Category getAccount(long id);
	Category addUpdateAccount(Category category);
	List<Category> deleteAccount(Category category);
	List<Category> deleteAllAccount();
	Category getAccountByName(String name);
	
}
