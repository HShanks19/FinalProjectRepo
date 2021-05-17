package com.qa.citizen.rest.DTOs;

public class PeopleMobileDTO {

	private String phoneNumber;
	private String network;

	public PeopleMobileDTO(String phoneNumber, String network) {
		super();
		this.phoneNumber = phoneNumber;
		this.network = network;
	}

	public PeopleMobileDTO() {
		super();
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
