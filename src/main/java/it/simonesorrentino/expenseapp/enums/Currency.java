package it.simonesorrentino.expenseapp.enums;

public enum Currency{

	YEN("JPY", "JP¥"),
	EURO("EUR", "€"),
	US_DOLLAR("USD", "$"),
	RENMIBI("CNY", "CN¥"),
	RUBLE("RUB", "RUB"),
	GB_POUND("GBP", "£");
	
	private String code;
	private String symbol;
	
	private Currency(String code, String symbol) {
		this.code = code;
		this.symbol = symbol;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
	
	
	
	

}
