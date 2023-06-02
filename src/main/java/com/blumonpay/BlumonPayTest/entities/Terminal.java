package com.blumonpay.BlumonPayTest.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "terminals")
public class Terminal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTerminal;
	
	private String name;
	private String lastName;
	private LocalDate bornDate;
	private String cardNumber;
	private String bank;
	public Long getIdTerminal() {
		return idTerminal;
	}
	public void setIdTerminal(Long idTerminal) {
		this.idTerminal = idTerminal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBornDate() {
		return bornDate;
	}
	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Terminal [idTerminal=").append(idTerminal).append(", name=").append(name).append(", lastName=")
				.append(lastName).append(", bornDate=").append(bornDate).append(", cardNumber=").append(cardNumber)
				.append(", bank=").append(bank).append("]");
		return builder.toString();
	}
	
	
	
	
	
}
