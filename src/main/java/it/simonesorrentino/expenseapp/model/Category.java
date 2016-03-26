package it.simonesorrentino.expenseapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.simonesorrentino.expenseapp.enums.Type;

@Entity(name="categoria")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="descrizione")
	private String name;
	
	@Column(name="data_insetimento", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInsermento;
	
	@Column(name="tipo")
	@Enumerated(EnumType.STRING)
	private Type tipo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDataInsermento() {
		return dataInsermento;
	}
	public void setDataInsermento(Date dataInsermento) {
		this.dataInsermento = dataInsermento;
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
		builder.append("Category [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", dataInsermento=");
		builder.append(dataInsermento);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}
	
}
