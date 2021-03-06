package it.simonesorrentino.expenseapp.model;

import java.io.Serializable;
import java.util.Currency;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="conto")
public class Account implements Serializable{
	
	private static final long serialVersionUID = 5196359337989846771L;
	
	@Id
	@Column(name="id")
	private long id;
	@Column
	private Currency currency;
	@Column(name="descrizione")
	private String name;
	@Column
	private Double balance;
	@Column
	private Boolean includeInTotal;
	@Column(name="is_attivo")
	private Boolean isAttivo;
	@Column(name="data_insetimento", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInsermento;
	

	public Account(){
		super();
	}
	
	public Account(long id, Currency currency, String name, Double balance, boolean includeInTotal, boolean isAttivo,
			String descrizione) {
		super();
		this.id = id;
		this.currency = currency;
		this.name = name;
		this.balance = balance;
		this.includeInTotal = includeInTotal;
		this.isAttivo = isAttivo;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public boolean isIncludeInTotal() {
		return includeInTotal;
	}
	public void setIncludeInTotal(Boolean includeInTotal) {
		this.includeInTotal = includeInTotal;
	}
	public Boolean isAttivo() {
		return isAttivo;
	}
	public void setAttivo(Boolean isAttivo) {
		this.isAttivo = isAttivo;
	}
	public Date getDataInsermento() {
		return dataInsermento;
	}
	public void setDataInsermento(Date dataInsermento) {
		this.dataInsermento = dataInsermento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [id=");
		builder.append(id);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", name=");
		builder.append(name);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", includeInTotal=");
		builder.append(includeInTotal);
		builder.append(", isAttivo=");
		builder.append(isAttivo);
		builder.append(", dataInsermento=");
		builder.append(dataInsermento);
		builder.append("]");
		return builder.toString();
	}
	
	

}
