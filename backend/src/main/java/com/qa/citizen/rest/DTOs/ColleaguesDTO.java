package com.qa.citizen.rest.DTOs;

public class ColleaguesDTO {

	public ColleaguesDTO(String personName, String dateOfBirth) {
		super();
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
	}

	//from People Business Address by Workplace
	
	public ColleaguesDTO() {
		super();
	}
	
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
