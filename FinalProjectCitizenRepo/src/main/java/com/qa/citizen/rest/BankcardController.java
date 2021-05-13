package com.qa.citizen.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.Bankcard;
import com.qa.citizen.service.BankcardService;

@RestController
@CrossOrigin
public class BankcardController {

	private BankcardService service;

	public BankcardController(BankcardService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getBankcards/{bankAccountNumber}")
	public List<Bankcard> getAtmTransactionsByCard(@PathVariable Long bankAccountNumber) {
		return this.service.getBankCards(bankAccountNumber);
	}
	
	@GetMapping("/getBankcardsById/{bankCardId}")
	public List<Bankcard> getAtmTransactionsByBankCardId(@PathVariable Long bankCardId) {
		return this.service.getBankCardsById(bankCardId);
	}

}
