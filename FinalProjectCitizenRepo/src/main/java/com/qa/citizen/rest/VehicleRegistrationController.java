package com.qa.citizen.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.Epos;
import com.qa.citizen.domain.VehicleRegistration;
import com.qa.citizen.service.EposService;
import com.qa.citizen.service.VehicleRegistrationService;

@RestController
@CrossOrigin
public class VehicleRegistrationController {

	private VehicleRegistrationService service;

	public VehicleRegistrationController(VehicleRegistrationService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getVehicleRegistration/{id}")
	public VehicleRegistration getVehicleRegistrationById(@PathVariable Long id) {
		return this.service.getVehicleRegistrationById(id);
	}
}
