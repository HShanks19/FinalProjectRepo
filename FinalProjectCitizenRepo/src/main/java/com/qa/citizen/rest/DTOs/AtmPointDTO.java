package com.qa.citizen.rest.DTOs;

import java.util.Set;


public class AtmPointDTO {

	private String streetName;
	
	private String postcode;

	private Set<AtmTransactionsDTO> AtmTransactions;

	public AtmPointDTO(String streetName, String postcode, Set<AtmTransactionsDTO> AtmTransactions) {
		super();
		this.streetName = streetName;
		this.postcode = postcode;
		this.AtmTransactions = AtmTransactions;
	}
	
	public AtmPointDTO() {
		super();
	}

	public Set<AtmTransactionsDTO> getAtmTransactions() {
		return AtmTransactions;
	}

	public void setAtmTransactions(Set<AtmTransactionsDTO> atmTransactions) {
		AtmTransactions = atmTransactions;
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
