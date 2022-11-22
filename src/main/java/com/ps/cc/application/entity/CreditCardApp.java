package com.ps.cc.application.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CREDITCARD" )
public class CreditCardApp implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "CARD_NUMBER", nullable = false)
	private String cardNumber;

	@Column(name = "BALANCE")
	private String balance;

	@Column(name = "`LIMIT`")
	private String limit;

	@Override
	public String toString() {
		return "CreditCardApp [id=" + id + ", name=" + name + ", cardNumber=" + cardNumber + ", balance=" + balance
				+ ", limit=" + limit + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCardApp other = (CreditCardApp) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(cardNumber, other.cardNumber)
				&& Objects.equals(id, other.id) && Objects.equals(limit, other.limit)
				&& Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, cardNumber, id, limit, name);
	}
	
	
}
