package com.qa.citizen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EposTransactions {
	
	public EposTransactions() {
		super();
	}

	public EposTransactions(Long eposId, Long bankCardNumber, Long payeeAccount, Double amount) {
		super();
		this.eposId = eposId;
		this.bankCardNumber = bankCardNumber;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}

	public EposTransactions(String timestamp, Long eposId, Long bankCardNumber, Long payeeAccount, Double amount) {
		super();
		this.timestamp = timestamp;
		this.eposId = eposId;
		this.bankCardNumber = bankCardNumber;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}

	@Id
	@Column(name = "timestamp")
	private String timestamp;
	
	@Column(name = "epos_id")
	private Long eposId;
	
	@Column(name = "bank_card_number")
	private Long bankCardNumber;
	
	@Column(name = "payee_account")
	private Long payeeAccount;
	
	@Column(name = "amount")
	private Double amount;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Long getEposId() {
		return eposId;
	}

	public void setEposId(Long eposId) {
		this.eposId = eposId;
	}

	public Long getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(Long bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public Long getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(Long payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
