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

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setCitizensMobileNumbers(List<PeopleMobileDTO> peopleMobileDTOList) {
		this.citizensMobileNumbers = peopleMobileDTOList;
	}

	public void setCitizensVehicles(List<VehicleRegistrationDTO> list) {
		this.citizensVehicles = list;
	}

	public String getForenames() {
		return forenames;
	}

	public String getSurname() {
		return surname;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public List<PeopleMobileDTO> getCitizensMobileNumbers() {
		return citizensMobileNumbers;
	}

	public List<VehicleRegistrationDTO> getCitizensVehicles() {
		return citizensVehicles;
	}

}
