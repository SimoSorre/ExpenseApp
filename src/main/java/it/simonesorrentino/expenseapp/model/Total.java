package it.simonesorrentino.expenseapp.model;

import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="totale")
public class Total {
	
	@Id
	@Column(name="account_id")
	@JsonIgnore
	private long accountId;
	@Column
	private Currency currency;
	@Column
	private Double total;
	
	public Total() {
		super();
	}
	
	public Total(long accountId, Currency currency, Double total) {
		super();
		this.accountId = accountId;
		this.currency = currency;
		this.total = total;
	}

	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Total [accountId=");
		builder.append(accountId);
		builder.append(", currency=");
		builder.append(currency);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}
	
}
