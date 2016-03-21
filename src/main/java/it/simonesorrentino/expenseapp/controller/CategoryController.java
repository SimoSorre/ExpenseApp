package it.simonesorrentino.expenseapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.simonesorrentino.expenseapp.service.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private CategoryService cs;

}
