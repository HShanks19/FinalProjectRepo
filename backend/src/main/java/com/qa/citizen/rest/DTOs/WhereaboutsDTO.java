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

}
