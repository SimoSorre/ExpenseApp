package it.simonesorrentino.expenseapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.simonesorrentino.expenseapp.enums.Type;
import it.simonesorrentino.expenseapp.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Override
	List<Category> findAll();
	Category findById(long id);
	Category findByName(String name);
	List<Category> findByTipo(Type tipo);
	
	Category save(Category category);
	
	@Override
	void delete(Category category);
	void deleteAll();
	
}
