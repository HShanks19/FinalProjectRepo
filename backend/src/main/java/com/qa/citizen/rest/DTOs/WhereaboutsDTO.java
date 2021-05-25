package com.qa.citizen.rest.DTOs;

import java.util.List;

public class WhereaboutsDTO {

	private Long bankAccountId;
	private Long cardNumber;

	private List<LocationAtmDTO> LocationATMDTOList;
	private List<LocationEposDTO> LocationEposDTOList;

	public WhereaboutsDTO(Long bankAccountId, Long cardNumber, List<LocationAtmDTO> locationATMDTOList,
			List<LocationEposDTO> locationEposDTOList) {
		super();
		this.bankAccountId = bankAccountId;
		this.cardNumber = cardNumber;
		LocationATMDTOList = locationATMDTOList;
		LocationEposDTOList = locationEposDTOList;
	}

	public WhereaboutsDTO() {
		super();
	}

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public List<LocationAtmDTO> getLocationATMDTOList() {
		return LocationATMDTOList;
	}

	public void setLocationATMDTOList(List<LocationAtmDTO> locationATMDTOList) {
		LocationATMDTOList = locationATMDTOList;
	}

	public List<LocationEposDTO> getLocationEposDTOList() {
		return LocationEposDTOList;
	}

	public void setLocationEposDTOList(List<LocationEposDTO> locationEposDTOList) {
		LocationEposDTOList = locationEposDTOList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocationATMDTOList == null) ? 0 : LocationATMDTOList.hashCode());
		result = prime * result + ((LocationEposDTOList == null) ? 0 : LocationEposDTOList.hashCode());
		result = prime * result + ((bankAccountId == null) ? 0 : bankAccountId.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
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
		WhereaboutsDTO other = (WhereaboutsDTO) obj;
		if (LocationATMDTOList == null) {
			if (other.LocationATMDTOList != null)
				return false;
		} else if (!LocationATMDTOList.equals(other.LocationATMDTOList))
			return false;
		if (LocationEposDTOList == null) {
			if (other.LocationEposDTOList != null)
				return false;
		} else if (!LocationEposDTOList.equals(other.LocationEposDTOList))
			return false;
		if (bankAccountId == null) {
			if (other.bankAccountId != null)
				return false;
		} else if (!bankAccountId.equals(other.bankAccountId))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WhereaboutsDTO [bankAccountId=" + bankAccountId + ", cardNumber=" + cardNumber + ", LocationATMDTOList="
				+ LocationATMDTOList + ", LocationEposDTOList=" + LocationEposDTOList + "]";
	}

}
