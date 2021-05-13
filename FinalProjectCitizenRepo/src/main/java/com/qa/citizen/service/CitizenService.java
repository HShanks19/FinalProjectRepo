package com.qa.citizen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.repo.CitizenRepo;

@Service
public class CitizenService {

	private CitizenRepo repo;

	public CitizenService(CitizenRepo repo) {
		super();
		this.repo = repo;
	}

	public List<Citizen> getCitizen() {
		return this.repo.findAll();
	}

	public Citizen getCitizenById(Long id) {
		Optional<Citizen> optCitizen = this.repo.findById(id);
		return optCitizen.get();
	}
	

	public List<Citizen> sortAndFilterDucks(Citizen citizen) {
		return this.repo.findAll(Example.of(citizen));
	}

}
