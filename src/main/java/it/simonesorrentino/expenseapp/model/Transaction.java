package it.simonesorrentino.expenseapp.model;

import java.util.Date;

import it.simonesorrentino.expenseapp.enums.Type;

public class Transaction {

	private long id;
	private Account accountFrom;
	private Account accountTo;
	private Double amount;
	private Date date;
	private String note;
	private Category category;
	private Type tipo;
	private String accountId;
	
	public Transaction() {
		super();
	}
	
	public Transaction(long id, Account accountFrom, Account accountTo, Double amount, Date date, String note,
			Category category, Type tipo, String accountId) {
		super();
		this.id = id;
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.amount = amount;
		this.date = date;
		this.note = note;
		this.category = category;
		this.tipo = tipo;
		this.accountId = accountId;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Account getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(Account accountFrom) {
		this.accountFrom = accountFrom;
	}
	public Account getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(Account accountTo) {
		this.accountTo = accountTo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Type getTipo() {
		return tipo;
	}
	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}
	
	public String getAccountId() {
		return accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [id=");
		builder.append(id);
		builder.append(", accountFrom=");
		builder.append(accountFrom);
		builder.append(", accountTo=");
		builder.append(accountTo);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", date=");
		builder.append(date);
		builder.append(", note=");
		builder.append(note);
		builder.append(", category=");
		builder.append(category);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", accountId=");
		builder.append(accountId);
		builder.append("]");
		return builder.toString();
	}
	
	

}
