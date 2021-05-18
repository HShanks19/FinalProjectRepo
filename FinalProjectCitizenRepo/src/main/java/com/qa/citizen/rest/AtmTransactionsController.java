package com.qa.citizen.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.citizen.domain.AtmTransaction;
import com.qa.citizen.domain.Bankcard;
import com.qa.citizen.rest.DTOs.AtmPointDTO;
import com.qa.citizen.rest.DTOs.AtmTransactionsDTO;
import com.qa.citizen.service.AtmTransactionService;

@RestController
@CrossOrigin
public class AtmTransactionsController {

	private AtmTransactionService service;

	public AtmTransactionsController(AtmTransactionService service) {
		super();
		this.service = service;
	}
	//DONT USE
	@GetMapping("/getATMTransactions/{bankCardNumber}")
	public List<AtmTransaction> getAtmTransactionsByCard(@PathVariable Bankcard cardNumber) {
		return this.service.getAtmTransactionsByCard(cardNumber);
	}
	//DONT USE
	@GetMapping("/getATMTransactionsDTO/{bankCardNumber}")
	public List<AtmTransactionsDTO> getDTO(@PathVariable Bankcard bankCardNumber) {
		return this.service.getDTO(bankCardNumber);
	}
	

}
