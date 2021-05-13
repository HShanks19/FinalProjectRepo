package com.qa.citizen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.VehicleRegistration;
import com.qa.citizen.repo.VehicleRegistrationRepo;

@Service
public class VehicleRegistrationService {

	private VehicleRegistrationRepo repo;
	
	public VehicleRegistrationService(VehicleRegistrationRepo repo) {
		super();
		this.repo = repo;
	}
	
	public VehicleRegistration getVehicleRegistrationById(Long id) {
		Optional<VehicleRegistration> optVehicleRegistration = this.repo.findById(id);
		return optVehicleRegistration.get();
	}

}
