package com.qa.citizen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EposTransactions {
	
	public EposTransactions() {
		super();
	}

	public EposTransactions(Long eposId, Long payeeAccount, Double amount) {
		super();
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}

	public EposTransactions(String timestamp, Long payeeAccount, Double amount) {
		super();
		this.timestamp = timestamp;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}

	@Id
	@Column(name = "timestamp")
	private String timestamp;
		
	@ManyToOne
	@JoinColumn(name="epos_id", nullable=false)
	private Epos id;
		
	@ManyToOne
	@JoinColumn(name="bank_card_number", nullable=false)
	private Bankcard bankCardNumber;
	
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

	public Epos getId() {
		return id;
	}

	public void setId(Epos id) {
		this.id = id;
	}

	public Bankcard getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(Bankcard bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	

}
