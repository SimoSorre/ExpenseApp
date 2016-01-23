package it.simonesorrentino.expenseapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.simonesorrentino.expenseapp.model.Message;

@RestController
@RequestMapping(value="/rest")
public class RestHomeController {
	
	List<Message> messaggi = new ArrayList<Message>();
	
	@RequestMapping(value = "{name}")
	public List<Message> getMessage(@PathVariable String name){
		
		Message msg = new Message(name, "Hello "+name);
		messaggi.add(msg);
		Message msg2 = new Message(name, "Ciao "+name);
		messaggi.add(msg2);
		
		return messaggi;
	}

}
