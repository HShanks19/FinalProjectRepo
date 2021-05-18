package com.qa.citizen.rest.DTOs;

public class EposDTO {

	public EposDTO(String vendor, String streetname, String postcode) {
		super();
		this.vendor = vendor;
		this.streetname = streetname;
		this.postcode = postcode;
	}

	public EposDTO() {
		super();
	}
	
	private String vendor;
	
	private String streetname;
	
	private String postcode;

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
