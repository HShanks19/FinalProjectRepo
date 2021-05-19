package com.qa.citizen.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/getMatchingBankAccounts/")
	public ResponseEntity<List<PeopleBankAccountDTO>> sortAndFilterBankAccounts(
			@RequestBody PeopleBankAccount peopleBankAccount) {
		return ResponseEntity.ok(this.service.sortAndFilterBankAccounts(peopleBankAccount));
	}

}
