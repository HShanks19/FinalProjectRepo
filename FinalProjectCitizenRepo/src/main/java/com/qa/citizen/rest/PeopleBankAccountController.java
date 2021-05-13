package com.qa.citizen.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.PeopleBankAccount;
import com.qa.citizen.rest.DTOs.PeopleBankAccountDTO;
import com.qa.citizen.service.PeopleBankAccountService;

@RestController
@CrossOrigin
public class PeopleBankAccountController {

	private PeopleBankAccountService service;

	public PeopleBankAccountController(PeopleBankAccountService service) {
		super();
		this.service = service;
	}
		
	@GetMapping("/getBankAccountDTO/{accountNumber}")
	public PeopleBankAccountDTO getBankAccountByIDDTO(@PathVariable Long accountNumber) {
		return this.service.getDTO(accountNumber);
	}

}
