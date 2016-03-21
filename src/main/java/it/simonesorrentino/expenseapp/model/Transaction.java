package it.simonesorrentino.expenseapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import it.simonesorrentino.expenseapp.enums.Type;

@Entity(name="movimento")
public class Transaction {

	@Id
	@Column(name="id")
	private long id;
	@Column(name="da_conto")
	private String accountFrom;
	@Column(name="a_conto")
	private String accountTo;
	@Column(name="importo")
	private Double amount;
	@Column(name="data")
	private Date date;
	@Column(name="descrizione")
	private String note;
	@Column(name="categoria")
	private String category;
	@Column
	private Type tipo;
	
	
	public Transaction() {
		super();
	}
	
	public Transaction(long id, String accountFrom, String accountTo, Double amount, Date date, String note,
			String category, Type tipo, String accountId) {
		super();
		this.id = id;
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.amount = amount;
		this.date = date;
		this.note = note;
		this.category = category;
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}
	public String getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(String accountTo) {
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Type getTipo() {
		return tipo;
	}
	public void setTipo(Type tipo) {
		this.tipo = tipo;
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
		builder.append("]");
		return builder.toString();
	}
	
	

}
