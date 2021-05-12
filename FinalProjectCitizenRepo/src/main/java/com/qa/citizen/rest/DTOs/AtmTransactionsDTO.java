package com.qa.citizen.rest.DTOs;

public class AtmTransactionsDTO {

	public AtmTransactionsDTO(String timestamp, Long bankCardNumber, String type, Double amount) {
		super();
		this.timestamp = timestamp;
		this.bankCardNumber = bankCardNumber;
		this.type = type;
		this.amount = amount;
	}
	
	public AtmTransactionsDTO() {
		super();
	}
	
	private String timestamp;

	private Long bankCardNumber;
	
	private String type;
	
	private Double amount;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

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
	

}
