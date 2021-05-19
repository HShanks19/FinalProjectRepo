package com.qa.citizen.service;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Example;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.AtmPoint;
import com.qa.citizen.domain.AtmTransaction;
import com.qa.citizen.domain.Bankcard;
import com.qa.citizen.domain.Epos;
import com.qa.citizen.domain.EposTransactions;
import com.qa.citizen.domain.PeopleBankAccount;
import com.qa.citizen.repo.PeopleBankAccountRepo;
import com.qa.citizen.rest.DTOs.AtmTransactionsDTO;
import com.qa.citizen.rest.DTOs.BankcardDTO;
import com.qa.citizen.rest.DTOs.EposTransactionsDTO;
import com.qa.citizen.rest.DTOs.PeopleBankAccountDTO;

@Service
public class PeopleBankAccountService {

	private PeopleBankAccountRepo repo;

	public PeopleBankAccountService(PeopleBankAccountRepo repo) {
		super();
		this.repo = repo;
	}

	private AtmTransactionsDTO mapToDTO(AtmTransaction atmTransaction) {
		AtmTransactionsDTO atmTransactionDTO = new AtmTransactionsDTO();

		atmTransactionDTO.setTimestamp(atmTransaction.getTimestamp());
		atmTransactionDTO.setType(atmTransaction.getType());
		atmTransactionDTO.setAmount(atmTransaction.getAmount());

		AtmPoint atmPoint = atmTransaction.getAtmId();

		atmTransactionDTO.setOperator(atmPoint.getOperator());
		atmTransactionDTO.setStreetName(atmPoint.getStreetName());
		atmTransactionDTO.setPostcode(atmPoint.getPostcode());

		return atmTransactionDTO;
	}

	private EposTransactionsDTO mapToDTO(EposTransactions eposTransaction) {
		EposTransactionsDTO eposTransactionDTO = new EposTransactionsDTO();

		eposTransactionDTO.setTimestamp(eposTransaction.getTimestamp());
		eposTransactionDTO.setAmount(eposTransaction.getAmount());

		Epos epos = eposTransaction.getId();

		eposTransactionDTO.setVendor(epos.getVendor());
		eposTransactionDTO.setStreetName(epos.getStreetName());
		eposTransactionDTO.setPostcode(epos.getPostcode());

		return eposTransactionDTO;
	}

	private BankcardDTO mapToDTO(Bankcard bankcard) {
		BankcardDTO dto = new BankcardDTO();
		dto.setSortCode(bankcard.getSortCode());

		Set<AtmTransactionsDTO> atmTransactionDTOs = new HashSet<>();

		for (AtmTransaction atmTransaction : bankcard.getAtmTransactions()) {
			AtmTransactionsDTO atmTransactionDTO = this.mapToDTO(atmTransaction);
			atmTransactionDTOs.add(atmTransactionDTO);
		}

		dto.setAtmTransactions(atmTransactionDTOs);

		Set<EposTransactionsDTO> eposTransactionDTOs = new HashSet<>();

		for (EposTransactions eposTransaction : bankcard.getEposTransactions()) {
			EposTransactionsDTO eposTransactionDTO = this.mapToDTO(eposTransaction);
			eposTransactionDTOs.add(eposTransactionDTO);
		}

		dto.setEposTransactions(eposTransactionDTOs);

		return dto;
	}

	private PeopleBankAccountDTO mapToDTO(PeopleBankAccount peopleBankAccount) {
		PeopleBankAccountDTO peopleDto = new PeopleBankAccountDTO();
		peopleDto.setBank(peopleBankAccount.getBank());
		peopleDto.setAccountNumber(peopleBankAccount.getAccountNumber());
		peopleDto.setForenames(peopleBankAccount.getForenames());
		peopleDto.setSurname(peopleBankAccount.getSurname());

		Set<BankcardDTO> bankcardDTOs = new HashSet<>();

		for (Bankcard bankcard : peopleBankAccount.getBankcards()) {
			BankcardDTO bankcardDTO = this.mapToDTO(bankcard);
			bankcardDTOs.add(bankcardDTO);
		}

		peopleDto.setBankcardDTOs(bankcardDTOs);


		return peopleDto;
	}

	public PeopleBankAccountDTO getDTO(Long id) {
		PeopleBankAccount found = this.repo.findByAccountNumber(id);
		PeopleBankAccountDTO dto = this.mapToDTO(found);

		return dto;
	}

	public List<PeopleBankAccountDTO> sortAndFilterBankAccounts(PeopleBankAccount peopleBankAccount) {
		List<PeopleBankAccount> bankAccountList = this.repo.findAll(Example.of(peopleBankAccount));
		List<PeopleBankAccountDTO> bankAccountDTOList = new ArrayList<>();

		for (PeopleBankAccount bankAccount : bankAccountList) {
			PeopleBankAccountDTO dto = this.mapToDTO(bankAccount);
			bankAccountDTOList.add(dto);
		}

		return bankAccountDTOList;
	}

}
