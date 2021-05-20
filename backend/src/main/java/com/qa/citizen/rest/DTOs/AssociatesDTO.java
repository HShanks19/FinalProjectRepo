package com.qa.citizen.rest.DTOs;

import java.util.List;

public class AssociatesDTO {

	public AssociatesDTO(List<PeopleMobileDTO> callRecords, String businessName, String businessAddress,
			List<ColleaguesDTO> collegues, List<HouseholdDTO> household) {
		super();
		this.callRecords = callRecords;
		this.businessName = businessName;
		this.businessAddress = businessAddress;
		this.collegues = collegues;
		this.household = household;
	}

	public AssociatesDTO() {
		super();
	}

	private List<PeopleMobileDTO> callRecords;
	
	private String businessName;
	
	private String businessAddress; 
	
	//name and DOB
	private List<ColleaguesDTO> collegues;
		
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

	public List<ColleaguesDTO> getCollegues() {
		return collegues;
	}

	public void setCollegues(List<ColleaguesDTO> collegues) {
		this.collegues = collegues;
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
