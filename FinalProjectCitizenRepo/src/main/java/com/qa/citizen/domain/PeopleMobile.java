package com.qa.citizen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PeopleMobile {

	public PeopleMobile(String forenames, String surname, String dateOfBirth, String address, String town,
			String postcode, String phoneNumber, String network) {
		super();
		this.forenames = forenames;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.town = town;
		this.postcode = postcode;
		this.phoneNumber = phoneNumber;
		this.network = network;
	}

	public PeopleMobile() {
		super();
	}
	
	@Column(name = "forenames")
	private String forenames;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "town")
	private String town;
	
	@Column(name = "postcode")
	private String postcode;
	
	@Id
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "network")
	private String network;

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

}
