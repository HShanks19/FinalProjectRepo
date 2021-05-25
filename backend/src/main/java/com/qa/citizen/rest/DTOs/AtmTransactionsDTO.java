package com.qa.citizen.rest.DTOs;

public class AtmTransactionsDTO {

	public AtmTransactionsDTO(String timestamp, String type, Double amount, String operator, String streetName,
			String postcode) {
		super();
		this.timestamp = timestamp;
		this.type = type;
		this.amount = amount;
		this.operator = operator;
		this.streetName = streetName;
		this.postcode = postcode;
	}

	public AtmTransactionsDTO(String timestamp, String type, Double amount) {
		super();
		this.timestamp = timestamp;
		this.type = type;
		this.amount = amount;
	}

	public AtmTransactionsDTO() {
		super();
	}

	private String timestamp;

	private String type;

	private Double amount;

//	private AtmPoint atmId;
	private String operator;

	private String streetName;

	private String postcode;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
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

//	public AtmPoint getAtmId() {
//		return atmId;
//	}
//
//	public void setAtmId(AtmPoint atmId) {
//		this.atmId = atmId;
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
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		AtmTransactionsDTO other = (AtmTransactionsDTO) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
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
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtmTransactionsDTO [timestamp=" + timestamp + ", type=" + type + ", amount=" + amount + ", operator="
				+ operator + ", streetName=" + streetName + ", postcode=" + postcode + "]";
	}

}
