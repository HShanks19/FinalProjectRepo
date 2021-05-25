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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileCallRecords == null) ? 0 : mobileCallRecords.hashCode());
		result = prime * result + ((network == null) ? 0 : network.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		PeopleMobileDTO other = (PeopleMobileDTO) obj;
		if (mobileCallRecords == null) {
			if (other.mobileCallRecords != null)
				return false;
		} else if (!mobileCallRecords.equals(other.mobileCallRecords))
			return false;
		if (network == null) {
			if (other.network != null)
				return false;
		} else if (!network.equals(other.network))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PeopleMobileDTO [phoneNumber=" + phoneNumber + ", network=" + network + ", mobileCallRecords="
				+ mobileCallRecords + "]";
	}

}
