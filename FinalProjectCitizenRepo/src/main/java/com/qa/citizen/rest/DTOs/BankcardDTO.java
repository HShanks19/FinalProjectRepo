package com.qa.citizen.rest.DTOs;

import java.util.Set;

public class BankcardDTO {

	public BankcardDTO(String sortCode, Set<AtmTransactionsDTO> atmTransactions,
			Set<EposTransactionsDTO> eposTransactions) {
		super();
		this.sortCode = sortCode;
		AtmTransactions = atmTransactions;
		EposTransactions = eposTransactions;
	}

	public BankcardDTO(String sortCode) {
		super();
		this.sortCode = sortCode;
	}

	public BankcardDTO() {
		super();
	}

	private String sortCode;
	
	private Set<AtmTransactionsDTO> AtmTransactions;
	
	private Set<EposTransactionsDTO> EposTransactions;

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public Set<AtmTransactionsDTO> getAtmTransactions() {
		return AtmTransactions;
	}

	public void setAtmTransactions(Set<AtmTransactionsDTO> atmTransactions) {
		AtmTransactions = atmTransactions;
	}

	public Set<EposTransactionsDTO> getEposTransactions() {
		return EposTransactions;
	}

	public void setEposTransactions(Set<EposTransactionsDTO> eposTransactions) {
		EposTransactions = eposTransactions;
	}

}
