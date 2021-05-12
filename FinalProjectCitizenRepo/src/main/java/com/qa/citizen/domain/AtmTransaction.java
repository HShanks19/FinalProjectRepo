package com.qa.citizen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AtmTransaction {

	public AtmTransaction(String timestamp, Long bankCardNumber, String type, Double amount) {
		super();
		this.timestamp = timestamp;
		this.bankCardNumber = bankCardNumber;
		this.type = type;
		this.amount = amount;
	}

	public AtmTransaction() {
		super();
	}
	
	@ManyToOne
	@JoinColumn(name="atm_id", nullable=false)
	private AtmPoint atmId;
	
	@Id
	@Column(name = "timestamp")
	private String timestamp;
	
//	@Column(name = "atm_id")
//	private Long atmId;
	
	@Column(name = "bank_card_number")
	private Long bankCardNumber;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "amount")
	private Double amount;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

//	public Long getAtmId() {
//		return atmId;
//	}

//	public void setAtmId(Long atmId) {
//		this.atmId = atmId;
//	}

	public Long getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(Long bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public AtmPoint getAtmId() {
		return atmId;
	}

	public void setAtmId(AtmPoint atmId) {
		this.atmId = atmId;
	}

}
