package it.simonesorrentino.expenseapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.simonesorrentino.expenseapp.enums.Type;
import it.simonesorrentino.expenseapp.model.Category;
import it.simonesorrentino.expenseapp.repository.CategoryRepository;
import it.simonesorrentino.expenseapp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategory(long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public Category addUpdateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> deleteCategory(Category category) {
		categoryRepository.delete(category);
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> deleteAllCategory() {
		categoryRepository.deleteAll();
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryByName(String name) {
		return categoryRepository.findByName(name);
	}

	@Override
	public List<Category> getCategoryByTipo(Type tipo) {
		return categoryRepository.findByTipo(tipo);
	}

}
