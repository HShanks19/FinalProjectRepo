package com.qa.citizen.rest.DTOs;

public class HouseholdDTO {
	//from Citizen by homeAddress
	
	public HouseholdDTO(String forenames, String surname, String dateOfBirth) {
		super();
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	public HouseholdDTO() {
		super();
	}
	
	// compound result of forenames and surname
	private String forenames;
	
	private String surname;
	
	private String dateOfBirth;

	

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
