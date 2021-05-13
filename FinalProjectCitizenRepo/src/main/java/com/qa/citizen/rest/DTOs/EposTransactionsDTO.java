package com.qa.citizen.rest.DTOs;

public class EposTransactionsDTO {

	public EposTransactionsDTO(String timestamp, Double amount, String streetName, String postcode) {
		super();
		this.timestamp = timestamp;
		this.amount = amount;
		this.streetName = streetName;
		this.postcode = postcode;
	}

	public EposTransactionsDTO(String timestamp, Double amount) {
		super();
		this.timestamp = timestamp;
		this.amount = amount;
	}

	public EposTransactionsDTO() {
		super();
	}
	
	private String timestamp;
	
	private Double amount;
	
	private String streetName;
	
	private String postcode;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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
