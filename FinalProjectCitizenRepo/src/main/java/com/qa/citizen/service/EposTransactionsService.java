package com.qa.citizen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.EposTransactions;
import com.qa.citizen.repo.EposTransactionsRepo;

@Service
public class EposTransactionsService {

	private EposTransactionsRepo repo;
	
	public EposTransactionsService(EposTransactionsRepo repo) {
		super();
		this.repo = repo;
	}
	
	public List<EposTransactions> getEposTransactionsByCard(Long bankCardNumber) {
		List<EposTransactions> cardTransactions = this.repo.findByBankCardNumber(bankCardNumber);
		return cardTransactions;
	}

}
