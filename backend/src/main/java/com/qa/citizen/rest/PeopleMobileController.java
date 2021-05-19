package com.qa.citizen.rest;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.PeopleMobile;
import com.qa.citizen.rest.DTOs.PeopleMobileDTO;
import com.qa.citizen.service.PeopleMobileService;

@RestController
@CrossOrigin
public class PeopleMobileController {

	private PeopleMobileService service;

	public PeopleMobileController(PeopleMobileService service) {
		super();
		this.service = service;
	}

	@GetMapping("getByPhoneNumber/{phoneNumber}")
	public PeopleMobileDTO getPersonDTO(String phoneNumber) {
		PeopleMobile foundCitizen = this.service.getCitizen(phoneNumber);
		return this.service.mapToDTO(foundCitizen);
	}
	
	@PostMapping("/getAllCitizenPhoneInformationDTO/")
	public ResponseEntity<Set<PeopleMobileDTO>> sortAndFilterPeopleMobileDTO(@RequestBody PeopleMobile peopleMobile) {
		return ResponseEntity.ok(this.service.getDTO(peopleMobile));
	}

}
