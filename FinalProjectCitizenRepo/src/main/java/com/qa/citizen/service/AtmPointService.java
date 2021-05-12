package com.qa.citizen.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.AtmPoint;
import com.qa.citizen.domain.AtmTransaction;
import com.qa.citizen.repo.AtmPointRepo;
import com.qa.citizen.rest.DTOs.AtmPointDTO;
import com.qa.citizen.rest.DTOs.AtmTransactionsDTO;


@Service
public class AtmPointService {

	private AtmPointRepo repo;
	
	public AtmPointService(AtmPointRepo repo) {
		super();
		this.repo = repo;
	}
	
	public AtmPoint getAtmPointById(Long id) {
		Optional<AtmPoint> optAtmPoint = this.repo.findById(id);
		return optAtmPoint.get();
	}
	
	private AtmTransactionsDTO mapToDTO(AtmTransaction atmTransaction) {
		AtmTransactionsDTO atmTransactionDTO = new AtmTransactionsDTO();

		atmTransactionDTO.setTimestamp(atmTransaction.getTimestamp());
		atmTransactionDTO.setBankCardNumber(atmTransaction.getBankCardNumber());
		atmTransactionDTO.setType(atmTransaction.getType());
		atmTransactionDTO.setAmount(atmTransaction.getAmount());

		return atmTransactionDTO;
	}

	private AtmPointDTO mapToDTO(AtmPoint atmPoint) {
		AtmPointDTO dto = new AtmPointDTO();
		dto.setStreetName(atmPoint.getStreetName());
		dto.setPostcode(atmPoint.getPostcode());

		Set<AtmTransactionsDTO> atmTransactionDTOs = new HashSet<>();

		for (AtmTransaction atmTransaction : atmPoint.getAtmTransactions()) {
			AtmTransactionsDTO atmTransactionDTO = this.mapToDTO(atmTransaction);
			atmTransactionDTOs.add(atmTransactionDTO);
		}

		dto.setAtmTransactions(atmTransactionDTOs);

		return dto;
	}

	public AtmPointDTO getDTO(Long id) {
		Optional<AtmPoint> found = this.repo.findById(id);
		AtmPoint found2 = found.get();
		AtmPointDTO dto = this.mapToDTO(found2);
		
		return dto;
	}
	

}
