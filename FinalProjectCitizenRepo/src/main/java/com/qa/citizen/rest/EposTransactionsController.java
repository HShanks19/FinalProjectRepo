package com.qa.citizen.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.EposTransactions;
import com.qa.citizen.service.EposTransactionsService;

@RestController
@CrossOrigin
public class EposTransactionsController {

	private EposTransactionsService service;

	public EposTransactionsController(EposTransactionsService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getEposTransactions/{bankCardNumber}")
	public List<EposTransactions> getAtmTransactionsByCard(@PathVariable Long bankCardNumber) {
		return this.service.getEposTransactionsByCard(bankCardNumber);
	}

}
