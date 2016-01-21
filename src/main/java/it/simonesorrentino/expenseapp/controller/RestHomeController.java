package it.simonesorrentino.expenseapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.simonesorrentino.expenseapp.model.Message;

@RestController
@RequestMapping(value="/rest")
public class RestHomeController {
	
	@RequestMapping(value = "{name}")
	public Message getMessage(@PathVariable String name){
		Message msg = new Message(name, "Hello "+name);
		
		return msg;
	}

}
