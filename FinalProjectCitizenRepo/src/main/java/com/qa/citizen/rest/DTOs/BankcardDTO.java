package com.qa.citizen.rest.DTOs;

public class BankcardDTO {

	public BankcardDTO(String sortCode) {
		super();
		this.sortCode = sortCode;
	}

	public BankcardDTO() {
		super();
	}

	private String sortCode;

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}
}
