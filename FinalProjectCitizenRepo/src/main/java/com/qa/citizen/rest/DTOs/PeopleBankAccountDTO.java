package com.qa.citizen.rest.DTOs;

public class PeopleBankAccountDTO {

	public PeopleBankAccountDTO(String bank, Long accountNumber, String forenames, String surname) {
		super();
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.forenames = forenames;
		this.surname = surname;
	}

	public PeopleBankAccountDTO() {
		super();
	}
	
	private String bank;
	
	private Long accountNumber;
	
	private String forenames;
	
	private String surname;

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
