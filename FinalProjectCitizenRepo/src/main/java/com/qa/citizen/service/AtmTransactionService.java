package com.qa.citizen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.AtmTransaction;
import com.qa.citizen.repo.AtmTransactionsRepo;

@Service
public class AtmTransactionService {

	private AtmTransactionsRepo repo;
	
	public AtmTransactionService(AtmTransactionsRepo repo) {
		super();
		this.repo = repo;
	}
	
	public List<AtmTransaction> getAtmTransactionsByCard(Long bankCardNumber) {
		List<AtmTransaction> cardTransactions = this.repo.findByBankCardNumber(bankCardNumber);
		return cardTransactions;
	}

}
