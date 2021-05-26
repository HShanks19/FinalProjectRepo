package com.qa.citizen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
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

	public List<PeopleBusinessAddress> sortAndFilterPeopleBusinessAddress(PeopleBusinessAddress peopleBusinessAddress) {
		return this.repo.findAll(Example.of(peopleBusinessAddress));
	}

	public List<PeopleBusinessAddress> getByBusinessAddress(String workplaceAddress) {
		List<PeopleBusinessAddress> peopleBusinessAddressList = this.repo.findByBusinessAddress(workplaceAddress);
		return peopleBusinessAddressList;
	}
}
