package com.qa.citizen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.AtmPoint;
import com.qa.citizen.repo.AtmPointRepo;

@Service
public class AtmPointService {

	private AtmPointRepo repo;
	
	public AtmPointService(AtmPointRepo repo) {
		super();
		this.repo = repo;
	}
	
	public AtmPoint getAtmPointById(Long id) {
		Optional<AtmPoint> optAtmPoint = this.repo.findById(id);
		return optAtmPoint.get();
	}
	

	

}
