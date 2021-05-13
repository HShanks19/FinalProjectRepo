package com.qa.citizen.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.AtmPoint;
import com.qa.citizen.domain.AtmTransaction;
import com.qa.citizen.domain.Bankcard;
import com.qa.citizen.domain.Epos;
import com.qa.citizen.domain.EposTransactions;
import com.qa.citizen.repo.BankcardRepo;
import com.qa.citizen.rest.DTOs.AtmTransactionsDTO;
import com.qa.citizen.rest.DTOs.BankcardDTO;
import com.qa.citizen.rest.DTOs.EposTransactionsDTO;

@Service
public class BankcardService {

private BankcardRepo repo;
	
	public BankcardService(BankcardRepo repo) {
		super();
		this.repo = repo;
	}
	
	public List<Bankcard> getBankCards(Long bankAccount) {
		List<Bankcard> bankcards = this.repo.findByAccountNumber(bankAccount);
		return bankcards;
	}
	
	public List<Bankcard> getBankCardsById(Long bankId) {
		List<Bankcard> bankcards = this.repo.findByBankCardId(bankId);
		return bankcards;
	}
	
	private AtmTransactionsDTO mapToAtmDTO(AtmTransaction atmTransaction) {
		AtmTransactionsDTO atmTransactionDTO = new AtmTransactionsDTO();

		atmTransactionDTO.setTimestamp(atmTransaction.getTimestamp());
		atmTransactionDTO.setType(atmTransaction.getType());
		atmTransactionDTO.setAmount(atmTransaction.getAmount());
		
		AtmPoint atmPoint = atmTransaction.getAtmId();
		
		atmTransactionDTO.setStreetName(atmPoint.getStreetName());
		atmTransactionDTO.setPostcode(atmPoint.getPostcode());		
		
		return atmTransactionDTO;
	}
	
	private EposTransactionsDTO mapToEposDTO(EposTransactions eposTransaction) {
		EposTransactionsDTO eposTransactionDTO = new EposTransactionsDTO();

		eposTransactionDTO.setTimestamp(eposTransaction.getTimestamp());
		eposTransactionDTO.setAmount(eposTransaction.getAmount());
		
		Epos epos = eposTransaction.getId();
		
		eposTransactionDTO.setStreetName(epos.getStreetName());
		eposTransactionDTO.setPostcode(epos.getPostcode());		
		
		return eposTransactionDTO;
	}
	
	private BankcardDTO mapToDTO(Bankcard bankcard) {
		BankcardDTO dto = new BankcardDTO();
		dto.setSortCode(bankcard.getSortCode());

		Set<AtmTransactionsDTO> atmTransactionDTOs = new HashSet<>();

		for (AtmTransaction atmTransaction : bankcard.getAtmTransactions()) {
			AtmTransactionsDTO atmTransactionDTO = this.mapToAtmDTO(atmTransaction);
			atmTransactionDTOs.add(atmTransactionDTO);
		}

		dto.setAtmTransactions(atmTransactionDTOs);
		
		Set<EposTransactionsDTO> eposTransactionDTOs = new HashSet<>();
		
		for (EposTransactions eposTransaction : bankcard.getEposTransactions()) {
			EposTransactionsDTO eposTransactionDTO = this.mapToEposDTO(eposTransaction);
			eposTransactionDTOs.add(eposTransactionDTO);
		}

		dto.setEposTransactions(eposTransactionDTOs);

		return dto;
	}
		
	public BankcardDTO getDTO(Long id) {
		Bankcard found = this.repo.findByCardNumber(id);
		BankcardDTO dto = this.mapToDTO(found);
		
		return dto;
	}

}
