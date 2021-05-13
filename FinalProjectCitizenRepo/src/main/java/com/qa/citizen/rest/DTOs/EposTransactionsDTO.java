package com.qa.citizen.rest.DTOs;

public class EposTransactionsDTO {

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
	

}
