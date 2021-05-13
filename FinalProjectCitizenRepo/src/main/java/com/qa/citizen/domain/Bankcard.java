package com.qa.citizen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bankcard {

	public Bankcard(Long cardNumber, String sortCode, Long bankAccountId, Long accountNumber, String bank) {
		super();
		this.cardNumber = cardNumber;
		this.sortCode = sortCode;
		this.bankAccountId = bankAccountId;
		this.accountNumber = accountNumber;
		this.bank = bank;
	}

	public Bankcard(Long bankCardId, Long cardNumber, String sortCode, Long bankAccountId, Long accountNumber,
			String bank) {
		super();
		this.bankCardId = bankCardId;
		this.cardNumber = cardNumber;
		this.sortCode = sortCode;
		this.bankAccountId = bankAccountId;
		this.accountNumber = accountNumber;
		this.bank = bank;
	}

	public Bankcard() {
		super();
	}
	
	@Id
	@Column(name = "bank_card_id")
	private Long bankCardId;
	
	@Column(name = "card_number")
	private Long cardNumber;
	
	@Column(name = "sort_code")
	private String sortCode;
	
	@Column(name = "bank_account_id")
	private Long bankAccountId;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	public Long getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(Long bankCardId) {
		this.bankCardId = bankCardId;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

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

	@Column(name = "bank")
	private String bank;

}
