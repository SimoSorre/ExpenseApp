package it.simonesorrentino.expenseapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import it.simonesorrentino.expenseapp.enums.Type;

@Entity(name="movimento")
public class Transaction {

	@Id
	@Column(name="id")
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="da_conto",referencedColumnName="id")
	private Account accountFrom;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="a_conto",referencedColumnName="id")
	private Account accountTo;
	
	@Column(name="importo")
	private Double amount;
	
	@Column(name="data", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	@Column(name="descrizione")
	private String note;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="categoria", referencedColumnName="id")
	private Category category;
	
	@Column(name="tipo")
	@Enumerated(EnumType.STRING)
	private Type tipo;
	
	
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
