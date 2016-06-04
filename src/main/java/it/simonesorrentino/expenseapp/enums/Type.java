package it.simonesorrentino.expenseapp.enums;

public enum Type {
	INCOME("INCOME"),
	EXPENSE("EXPENSE"),
	TRANSFER("TRANSFER");
	
	private String type;
	
	Type(String t){
		type = t;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Type getByString(String t){
		return Type.valueOf(t);
	}
	
	
}
