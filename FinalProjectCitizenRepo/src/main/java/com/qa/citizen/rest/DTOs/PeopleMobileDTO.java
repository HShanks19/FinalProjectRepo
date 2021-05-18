package com.qa.citizen.rest.DTOs;

import java.util.Set;

public class PeopleMobileDTO {

	public PeopleMobileDTO(String phoneNumber, String network, Set<MobileCallRecordsDTO> mobileCallRecords) {
		super();
		this.phoneNumber = phoneNumber;
		this.network = network;
		this.mobileCallRecords = mobileCallRecords;
	}

	public PeopleMobileDTO() {
		super();
	}
	private String phoneNumber;
	
	private String network;

	private Set<MobileCallRecordsDTO> mobileCallRecords;

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


	public Set<MobileCallRecordsDTO> getMobileCallRecords() {
		return mobileCallRecords;
	}

	public void setMobileCallRecords(Set<MobileCallRecordsDTO> mobileCallRecords) {
		this.mobileCallRecords = mobileCallRecords;
	}

}
