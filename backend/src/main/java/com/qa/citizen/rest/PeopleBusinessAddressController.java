package com.qa.citizen.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.PeopleBusinessAddress;
import com.qa.citizen.service.PeopleBusinessAddressService;

@RestController
@CrossOrigin
public class PeopleBusinessAddressController {

	private PeopleBusinessAddressService service;

	public PeopleBusinessAddressController(PeopleBusinessAddressService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getBusiness/{personName}")
	public PeopleBusinessAddress getWorkplaceByName(@PathVariable String personName) {
		return this.service.getWorkplaceByName(personName);
	}

	@PostMapping("/getAllBusinessAddressInformation/")
	public ResponseEntity<List<PeopleBusinessAddress>> sortAndFilterPeopleBusinessAddress(
			@RequestBody PeopleBusinessAddress peopleBusinessAddress) {
		return ResponseEntity.ok(this.service.sortAndFilterPeopleBusinessAddress(peopleBusinessAddress));
	}

}
