package com.qa.citizen.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.VehicleRegistration;
import com.qa.citizen.service.VehicleRegistrationService;

@RestController
@CrossOrigin
public class VehicleRegistrationController {

	private VehicleRegistrationService service;

	public VehicleRegistrationController(VehicleRegistrationService service) {
		super();
		this.service = service;
	}

	@PostMapping("/getAllVehicleRegistration/")
	public ResponseEntity<List<VehicleRegistration>> sortAndFilterVehicleRegistrations(
			@RequestBody VehicleRegistration vehicleRegistration) {
		return ResponseEntity.ok(this.service.sortAndFilterVehicleRegistrations(vehicleRegistration));
	}
}
