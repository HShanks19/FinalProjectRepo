package com.qa.citizen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PeopleBankAccount {

	public PeopleBankAccount(Long accountNumber, String bank, String forenames, String surname, String dateOfBirth,
			String homeAddress) {
		super();
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
	}

	public PeopleBankAccount(Long bankAccountId, Long accountNumber, String bank, String forenames, String surname,
			String dateOfBirth, String homeAddress) {
		super();
		this.bankAccountId = bankAccountId;
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
	}

	public PeopleBankAccount() {
		super();
	}
	
	@Id
	@Column(name = "bank_account_id")
	private Long bankAccountId;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "bank")
	private String bank;
	
	@Column(name = "forenames")
	private String forenames;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Column(name = "home_address")
	private String homeAddress;

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

}
