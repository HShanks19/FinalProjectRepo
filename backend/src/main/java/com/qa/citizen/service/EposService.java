package com.qa.citizen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.Epos;
import com.qa.citizen.repo.EposRepo;

@Service
public class EposService {

	private EposRepo repo;
	
	public EposService(EposRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Epos getEposById(Long id) {
		Optional<Epos> optEpos = this.repo.findById(id);
		return optEpos.get();
	}

}
