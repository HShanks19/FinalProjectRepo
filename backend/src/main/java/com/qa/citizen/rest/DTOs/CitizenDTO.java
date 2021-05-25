package com.qa.citizen.rest.DTOs;

import java.util.List;

public class CitizenDTO {

	public CitizenDTO(String forenames, String surname, String homeAddress, String dateOfBirth, String placeOfBirth,
			String sex, List<PeopleMobileDTO> citizensMobileNumbers, List<VehicleRegistrationDTO> citizensVehicles) {
		super();
		this.forenames = forenames;
		this.surname = surname;
		this.homeAddress = homeAddress;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.sex = sex;
		this.citizensMobileNumbers = citizensMobileNumbers;
		this.citizensVehicles = citizensVehicles;
	}

	public CitizenDTO(String forenames, String surname, String homeAddress, String dateOfBirth, String placeOfBirth,
			String sex) {
		super();
		this.forenames = forenames;
		this.surname = surname;
		this.homeAddress = homeAddress;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.sex = sex;
	}

	public CitizenDTO() {
		super();
	}

	private String forenames;

	private String surname;

	private String homeAddress;

	private String dateOfBirth;

	private String placeOfBirth;

	private String sex;

	private List<PeopleMobileDTO> citizensMobileNumbers;

	private List<VehicleRegistrationDTO> citizensVehicles;

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

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<PeopleMobileDTO> getCitizensMobileNumbers() {
		return citizensMobileNumbers;
	}

	public void setCitizensMobileNumbers(List<PeopleMobileDTO> citizensMobileNumbers) {
		this.citizensMobileNumbers = citizensMobileNumbers;
	}

	public List<VehicleRegistrationDTO> getCitizensVehicles() {
		return citizensVehicles;
	}

	public void setCitizensVehicles(List<VehicleRegistrationDTO> citizensVehicles) {
		this.citizensVehicles = citizensVehicles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citizensMobileNumbers == null) ? 0 : citizensMobileNumbers.hashCode());
		result = prime * result + ((citizensVehicles == null) ? 0 : citizensVehicles.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((forenames == null) ? 0 : forenames.hashCode());
		result = prime * result + ((homeAddress == null) ? 0 : homeAddress.hashCode());
		result = prime * result + ((placeOfBirth == null) ? 0 : placeOfBirth.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		CitizenDTO other = (CitizenDTO) obj;
		if (citizensMobileNumbers == null) {
			if (other.citizensMobileNumbers != null)
				return false;
		} else if (!citizensMobileNumbers.equals(other.citizensMobileNumbers))
			return false;
		if (citizensVehicles == null) {
			if (other.citizensVehicles != null)
				return false;
		} else if (!citizensVehicles.equals(other.citizensVehicles))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (forenames == null) {
			if (other.forenames != null)
				return false;
		} else if (!forenames.equals(other.forenames))
			return false;
		if (homeAddress == null) {
			if (other.homeAddress != null)
				return false;
		} else if (!homeAddress.equals(other.homeAddress))
			return false;
		if (placeOfBirth == null) {
			if (other.placeOfBirth != null)
				return false;
		} else if (!placeOfBirth.equals(other.placeOfBirth))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CitizenDTO [forenames=" + forenames + ", surname=" + surname + ", homeAddress=" + homeAddress
				+ ", dateOfBirth=" + dateOfBirth + ", placeOfBirth=" + placeOfBirth + ", sex=" + sex
				+ ", citizensMobileNumbers=" + citizensMobileNumbers + ", citizensVehicles=" + citizensVehicles + "]";
	}

}
