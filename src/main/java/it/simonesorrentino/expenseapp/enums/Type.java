package it.simonesorrentino.expenseapp.enums;

public enum Type {
	INCOME("INCOME"),
	EXPENSE("EXPENSE"),
	TRANSFER("TRANSFER");
	
	private String type;
	
	Type(String t){
		type = t;
	}
}
