package com.qa.citizen.service;

import java.util.List;

import org.springframework.data.domain.Example;
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

	public List<PeopleMobile> sortAndFilterPeopleMobile(PeopleMobile peopleMobile) {
		return this.repo.findAll(Example.of(peopleMobile));
	}

}
