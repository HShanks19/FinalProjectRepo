package com.qa.citizen.rest.DTOs;

import java.util.List;

public class AssociatesDTO {

	public AssociatesDTO(List<PeopleMobileDTO> callRecords, String businessName, String businessAddress,
			List<ColleaguesDTO> colleagues, List<HouseholdDTO> household) {
		super();
		this.callRecords = callRecords;
		this.businessName = businessName;
		this.businessAddress = businessAddress;
		this.colleagues = colleagues;
		this.household = household;
	}

	public AssociatesDTO() {
		super();
	}

	private List<PeopleMobileDTO> callRecords;

	private String businessName;

	private String businessAddress;

	// name and DOB
	private List<ColleaguesDTO> colleagues;

	//// name and DOB
	private List<HouseholdDTO> household;

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public List<ColleaguesDTO> getColleagues() {
		return colleagues;
	}

	public void setColleagues(List<ColleaguesDTO> colleagues) {
		this.colleagues = colleagues;
	}

	public List<HouseholdDTO> getHousehold() {
		return household;
	}

	public void setHousehold(List<HouseholdDTO> householdMembers) {
		this.household = householdMembers;
	}

	public List<PeopleMobileDTO> getCallRecords() {
		return callRecords;
	}

	public void setCallRecords(List<PeopleMobileDTO> callRecords) {
		this.callRecords = callRecords;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessAddress == null) ? 0 : businessAddress.hashCode());
		result = prime * result + ((businessName == null) ? 0 : businessName.hashCode());
		result = prime * result + ((callRecords == null) ? 0 : callRecords.hashCode());
		result = prime * result + ((colleagues == null) ? 0 : colleagues.hashCode());
		result = prime * result + ((household == null) ? 0 : household.hashCode());
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
		AssociatesDTO other = (AssociatesDTO) obj;
		if (businessAddress == null) {
			if (other.businessAddress != null)
				return false;
		} else if (!businessAddress.equals(other.businessAddress))
			return false;
		if (businessName == null) {
			if (other.businessName != null)
				return false;
		} else if (!businessName.equals(other.businessName))
			return false;
		if (callRecords == null) {
			if (other.callRecords != null)
				return false;
		} else if (!callRecords.equals(other.callRecords))
			return false;
		if (colleagues == null) {
			if (other.colleagues != null)
				return false;
		} else if (!colleagues.equals(other.colleagues))
			return false;
		if (household == null) {
			if (other.household != null)
				return false;
		} else if (!household.equals(other.household))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssociatesDTO [callRecords=" + callRecords + ", businessName=" + businessName + ", businessAddress="
				+ businessAddress + ", colleagues=" + colleagues + ", household=" + household + "]";
	}

}
