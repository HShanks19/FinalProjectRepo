package com.qa.citizen.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.AtmPoint;
import com.qa.citizen.service.AtmPointService;

@RestController
@CrossOrigin
public class AtmPointController {

	private AtmPointService service;

	public AtmPointController(AtmPointService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getATMPoint/{id}")
	public AtmPoint getAtmPointById(@PathVariable Long id) {
		return this.service.getAtmPointById(id);
	}

}
