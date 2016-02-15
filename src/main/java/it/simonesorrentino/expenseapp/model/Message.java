package it.simonesorrentino.expenseapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Message {
	
	@JsonIgnore
	private String name;
	private String message;
	
	public Message(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
