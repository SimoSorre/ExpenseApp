package it.simonesorrentino.expenseapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.simonesorrentino.expenseapp.enums.Type;
import it.simonesorrentino.expenseapp.model.Category;
import it.simonesorrentino.expenseapp.service.CategoryService;
import it.simonesorrentino.expenseapp.utility.FillerUtility;
import it.simonesorrentino.expenseapp.utility.JsonUtility;

@RestController
@RequestMapping("categories")
public class CategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	/*GET*/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAllCategories(){
		final String methodName = "getAllCategories";
		logger.info(methodName);
		
		List<Category> categoryList = categoryService.getAll();
		
		if(categoryList.isEmpty()){
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}else{
			return new ResponseEntity<Object> (categoryList, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCategory( @PathVariable("id") long id){
		final String methodName="getCategory";
		logger.info(methodName);
		
		return new ResponseEntity<Object> (categoryService.getCategory(id), HttpStatus.OK );
	}
	
	@RequestMapping(value="name/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByName(@PathVariable("name") String name){
		final String methodName="getByName";
		logger.info(methodName);
		
		return new ResponseEntity<Object> (categoryService.getCategoryByName(name), HttpStatus.OK );
	}
	
	@RequestMapping(value="type/{type}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByType(@PathVariable("type") String type){
		final String methodName="getByType";
		logger.info(methodName);
		
		return new ResponseEntity<Object> (categoryService.getCategoryByTipo(Type.valueOf(type)), HttpStatus.OK );
	}
	
	
	/*Fine GET*/
	
	
	/*POST*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addCategory(HttpServletRequest request){
		final String methodName = "addCategory";
		logger.info(methodName);
		
		JSONObject jsonCategory = JsonUtility.returnJson(request);

		Category category = null;
		try {
			category = FillerUtility.fillCategory(jsonCategory);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		categoryService.addUpdateCategory(category);
		
		return new ResponseEntity<Object>(category, HttpStatus.OK);
	}
	/*Fine POST*/
	
	/*PUT*/
	@RequestMapping(value="{id}", method= RequestMethod.PUT)
	public ResponseEntity<Object> updateCategory(@PathVariable("id") long id, HttpServletRequest request){
		final String methodName="updateCategory";
		logger.info(methodName);
		
		JSONObject jsonCategory = JsonUtility.returnJson(request);
		
		Category category = null;
		try {
			category = FillerUtility.fillCategory(jsonCategory, categoryService.getCategory(id));
			logger.info(category.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(categoryService.addUpdateCategory(category) , HttpStatus.OK);
	}
	/*Fine PUT*/
	
	/*DELETE*/
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCategory(@PathVariable("id") long id ){
		final String methodName="deleteCategory";
		logger.info(methodName);
		
		Category category = categoryService.getCategory(id);
		categoryService.deleteCategory(category);
		List<Category> categoryList = categoryService.getAll();
		
		return new ResponseEntity<Object> (categoryList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAllCategory(){
		final String methodName="deleteCategory";
		logger.info(methodName);
		
		categoryService.deleteAllCategory();
		List<Category> categoryList = categoryService.getAll();
		
		return new ResponseEntity<Object> (categoryList, HttpStatus.OK);
	}
	/*Fine DELETE*/

}
