package it.simonesorrentino.expenseapp.service;

import java.util.List;

import it.simonesorrentino.expenseapp.enums.Type;
import it.simonesorrentino.expenseapp.model.Category;

public interface CategoryService {
	
	List<Category> getAll();
	Category getCategory(long id);
	Category addUpdateCategory(Category category);
	List<Category> deleteCategory(Category category);
	Category getCategoryByName(String name);
	List<Category> getCategoryByTipo(Type tipo);
	List<Category> deleteAllCategory();
	
}
