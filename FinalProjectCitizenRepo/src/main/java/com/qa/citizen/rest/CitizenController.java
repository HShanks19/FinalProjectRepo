package com.qa.citizen.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.service.CitizenService;

@RestController
@CrossOrigin
public class CitizenController {

	private CitizenService service;

	public CitizenController(CitizenService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getCitizen/{id}")
	public Citizen getCitizenById(@PathVariable Long id) {
		return this.service.getCitizenById(id);
	}

	@GetMapping("/getCitizenFromSearch")
	public List<Citizen> getCitizenFromSearchForm(@RequestBody Citizen citizen) {
		Citizen foundCitizen = citizen;

		return this.service.findCitizenByCompleteSearch(foundCitizen);
	}

}
