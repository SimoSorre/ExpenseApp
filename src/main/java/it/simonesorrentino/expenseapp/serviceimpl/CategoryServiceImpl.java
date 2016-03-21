package it.simonesorrentino.expenseapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.simonesorrentino.expenseapp.model.Category;
import it.simonesorrentino.expenseapp.repository.CategoryRepository;
import it.simonesorrentino.expenseapp.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getAccount(long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public Category addUpdateAccount(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> deleteAccount(Category category) {
		categoryRepository.delete(category);
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> deleteAllAccount() {
		categoryRepository.deleteAll();
		return categoryRepository.findAll();
	}

	@Override
	public Category getAccountByName(String name) {
		return categoryRepository.findByName(name);
	}

}
