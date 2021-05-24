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
	
	//name and DOB
	private List<ColleaguesDTO> colleagues;
		
	////name and DOB
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
	
	
	
}
