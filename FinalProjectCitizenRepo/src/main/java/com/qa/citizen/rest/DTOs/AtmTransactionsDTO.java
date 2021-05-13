package com.qa.citizen.rest.DTOs;

import com.qa.citizen.domain.AtmPoint;
import com.qa.citizen.domain.Bankcard;

public class AtmTransactionsDTO {

	public AtmTransactionsDTO(String timestamp, Bankcard bankCardNumber, String type, Double amount, String streetName, String postcode) {
		super();
		this.timestamp = timestamp;
		this.bankCardNumber = bankCardNumber;
		this.type = type;
		this.amount = amount;
		this.streetName = streetName;
		this.postcode = postcode;
	}
	
	public AtmTransactionsDTO(String timestamp, Bankcard bankCardNumber, String type, Double amount, AtmPoint atmId) {
		super();
		this.timestamp = timestamp;
		this.bankCardNumber = bankCardNumber;
		this.type = type;
		this.amount = amount;
		this.atmId = atmId;
	}
	
	public AtmTransactionsDTO() {
		super();
	}
	
	private String timestamp;

	private Bankcard bankCardNumber;
	
	private String type;
	
	private Double amount;
	
	private AtmPoint atmId;
	
	private String streetName;
	
	private String postcode;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Bankcard getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(Bankcard bankCardNumber) {
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

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	

}
