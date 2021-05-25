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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AtmTransactions == null) ? 0 : AtmTransactions.hashCode());
		result = prime * result + ((EposTransactions == null) ? 0 : EposTransactions.hashCode());
		result = prime * result + ((sortCode == null) ? 0 : sortCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankcardDTO other = (BankcardDTO) obj;
		if (AtmTransactions == null) {
			if (other.AtmTransactions != null)
				return false;
		} else if (!AtmTransactions.equals(other.AtmTransactions))
			return false;
		if (EposTransactions == null) {
			if (other.EposTransactions != null)
				return false;
		} else if (!EposTransactions.equals(other.EposTransactions))
			return false;
		if (sortCode == null) {
			if (other.sortCode != null)
				return false;
		} else if (!sortCode.equals(other.sortCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankcardDTO [sortCode=" + sortCode + ", AtmTransactions=" + AtmTransactions + ", EposTransactions="
				+ EposTransactions + "]";
	}

}
