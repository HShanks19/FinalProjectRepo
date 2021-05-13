package com.qa.citizen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.PeopleBusinessAddress;
import com.qa.citizen.repo.PeopleBusinessAddressRepo;

@Service
public class PeopleBusinessAddressService {

	private PeopleBusinessAddressRepo repo;
	
	public PeopleBusinessAddressService(PeopleBusinessAddressRepo repo) {
		super();
		this.repo = repo;
	}
		
	public PeopleBusinessAddress getWorkplaceByName(String name) {
		Optional<PeopleBusinessAddress> optPeopleBusinessAddress = this.repo.findByPersonName(name);
		return optPeopleBusinessAddress.get();
	}
}
