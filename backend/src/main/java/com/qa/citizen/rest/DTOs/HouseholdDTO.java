package com.qa.citizen.rest.DTOs;

public class HouseholdDTO {

	public HouseholdDTO(String personName, String dateOfBirth) {
		super();
		this.personName = personName;
		this.dateOfBirth = dateOfBirth;
	}

	// from Citizen by homeAddress

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((personName == null) ? 0 : personName.hashCode());
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
		HouseholdDTO other = (HouseholdDTO) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (personName == null) {
			if (other.personName != null)
				return false;
		} else if (!personName.equals(other.personName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HouseholdDTO [personName=" + personName + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
