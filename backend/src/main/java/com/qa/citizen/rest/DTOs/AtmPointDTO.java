package com.qa.citizen.rest.DTOs;

//import java.util.Set;

public class AtmPointDTO {

	public AtmPointDTO(String operator, String streetName, String postcode) {
		super();
		this.Operator = operator;
		this.streetName = streetName;
		this.postcode = postcode;
	}

	private String Operator;

	private String streetName;

	private String postcode;

//	private Set<AtmTransactionsDTO> AtmTransactions;

//	public AtmPointDTO(String streetName, String postcode, Set<AtmTransactionsDTO> AtmTransactions) {
//		super();
//		this.streetName = streetName;
//		this.postcode = postcode;
//		this.AtmTransactions = AtmTransactions;
//	}

	public AtmPointDTO(String streetName, String postcode) {
		super();
		this.streetName = streetName;
		this.postcode = postcode;
	}

	public AtmPointDTO() {
		super();
	}

//	public Set<AtmTransactionsDTO> getAtmTransactions() {
//		return AtmTransactions;
//	}

//	public void setAtmTransactions(Set<AtmTransactionsDTO> atmTransactions) {
//		AtmTransactions = atmTransactions;
//	}

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

	public String getOperator() {
		return Operator;
	}

	public void setOperator(String operator) {
		Operator = operator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Operator == null) ? 0 : Operator.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
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
		AtmPointDTO other = (AtmPointDTO) obj;
		if (Operator == null) {
			if (other.Operator != null)
				return false;
		} else if (!Operator.equals(other.Operator))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtmPointDTO [Operator=" + Operator + ", streetName=" + streetName + ", postcode=" + postcode + "]";
	}

}
