package com.qa.citizen.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.AtmPoint;
import com.qa.citizen.domain.AtmTransaction;
import com.qa.citizen.repo.AtmTransactionsRepo;
import com.qa.citizen.rest.DTOs.AtmPointDTO;
import com.qa.citizen.rest.DTOs.AtmTransactionsDTO;

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
	
	private AtmPointDTO mapToDTO(AtmPoint atmPoint) {
		AtmPointDTO dto = new AtmPointDTO();
		dto.setStreetName(atmPoint.getStreetName());
		dto.setPostcode(atmPoint.getPostcode());
		return dto;
	}
	
	private AtmTransactionsDTO mapToDTO(AtmTransaction atmTransaction) {
		AtmTransactionsDTO atmTransactionDTO = new AtmTransactionsDTO();

		atmTransactionDTO.setTimestamp(atmTransaction.getTimestamp());
		atmTransactionDTO.setBankCardNumber(atmTransaction.getBankCardNumber());
		atmTransactionDTO.setType(atmTransaction.getType());
		atmTransactionDTO.setAmount(atmTransaction.getAmount());
				
		return atmTransactionDTO;
	}
	
	public List<AtmTransactionsDTO> getAtmTransactionsDTOByCard(Long bankCardNumber) {
		List<AtmTransaction> cardTransactions = this.repo.findByBankCardNumber(bankCardNumber);
		List<AtmTransactionsDTO> dtos = new ArrayList<>();

		for (AtmTransaction atmTransaction : cardTransactions) {
			AtmTransactionsDTO dto = this.mapToDTO(atmTransaction);
			dtos.add(dto);
		}

		return dtos;

	}

}
