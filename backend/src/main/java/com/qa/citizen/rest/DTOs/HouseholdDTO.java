package com.qa.citizen.rest.DTOs;

public class HouseholdDTO {

	public HouseholdDTO(String personName, String dateOfBirth) {
		super();
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
	}

	//from Citizen by homeAddress
	
	public HouseholdDTO() {
		super();
	}
	
	// compound result of forenames and surname
	private String personName;
	
	private String dateOfBirth;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
