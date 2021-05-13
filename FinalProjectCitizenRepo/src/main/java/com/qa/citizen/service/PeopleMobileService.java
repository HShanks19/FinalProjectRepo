package com.qa.citizen.service;


import org.springframework.stereotype.Service;

import com.qa.citizen.domain.PeopleMobile;
import com.qa.citizen.repo.PeopleMobileRepo;

@Service
public class PeopleMobileService {

	private PeopleMobileRepo repo;
	
	public PeopleMobileService(PeopleMobileRepo repo) {
		super();
		this.repo = repo;
	}
	
	public PeopleMobile getCitizen(String phoneNumber) {
		return this.repo.findByPhoneNumber(phoneNumber);
	}


}
