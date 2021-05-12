package com.qa.citizen.rest;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.PeopleMobile;
import com.qa.citizen.service.PeopleMobileService;

@RestController
@CrossOrigin
public class PeopleMobileController {

	private PeopleMobileService service;

	public PeopleMobileController(PeopleMobileService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getCitizenInformation/{phoneNumber}")
	public PeopleMobile getCitizenInformationFromPhoneNumber(@PathVariable String phoneNumber) {
		return this.service.getCitizen(phoneNumber);
	}

}
