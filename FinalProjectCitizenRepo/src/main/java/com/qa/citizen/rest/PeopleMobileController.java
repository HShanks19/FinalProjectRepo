package com.qa.citizen.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/getCitizenPhoneInformation/{phoneNumber}")
	public PeopleMobile getCitizenInformationFromPhoneNumber(@PathVariable String phoneNumber) {
		return this.service.getCitizen(phoneNumber);
	}

	@PostMapping("/getAllCitizenPhoneInformation/")
	public ResponseEntity<List<PeopleMobile>> sortAndFilterPeopleMobile(@RequestBody PeopleMobile peopleMobile) {
		return ResponseEntity.ok(this.service.sortAndFilterPeopleMobile(peopleMobile));
	}

}
