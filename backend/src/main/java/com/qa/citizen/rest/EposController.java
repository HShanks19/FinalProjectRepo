package com.qa.citizen.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.Epos;
import com.qa.citizen.service.EposService;

@RestController
@CrossOrigin
public class EposController {

	private EposService service;

	public EposController(EposService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getEpos/{id}")
	public Epos getEposById(@PathVariable Long id) {
		return this.service.getEposById(id);
	}

}
