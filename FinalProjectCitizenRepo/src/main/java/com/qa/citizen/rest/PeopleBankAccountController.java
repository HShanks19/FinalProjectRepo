package com.qa.citizen.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.PeopleBankAccount;
import com.qa.citizen.service.PeopleBankAccountService;

@RestController
@CrossOrigin
public class PeopleBankAccountController {

	private PeopleBankAccountService service;

	public PeopleBankAccountController(PeopleBankAccountService service) {
		super();
		this.service = service;
	}
	
	
	//currently not working (No Value Present)
	@GetMapping("/getBankAccount/{id}")
	public PeopleBankAccount getBankAccountById(@PathVariable Long id) {
		return this.service.getPeopleBankAccountById(id);
	}

}
