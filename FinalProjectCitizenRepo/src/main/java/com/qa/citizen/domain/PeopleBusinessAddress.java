package com.qa.citizen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PeopleBusinessAddress {

	public PeopleBusinessAddress() {
		super();
	}
	
	@Id
	@Column(name = "person_name")
	private String personName;
	
	@Column(name = "home_address")
	private String homeAddress;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Column(name = "business_name")
	private String businessName;
	
	@Column(name = "business_address")
	private String businessAddress;

}
