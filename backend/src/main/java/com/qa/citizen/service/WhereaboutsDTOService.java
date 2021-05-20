package com.qa.citizen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.AtmTransaction;
import com.qa.citizen.domain.Bankcard;
import com.qa.citizen.domain.Citizen;
import com.qa.citizen.domain.EposTransactions;
import com.qa.citizen.domain.PeopleBankAccount;
import com.qa.citizen.rest.DTOs.LocationAtmDTO;
import com.qa.citizen.rest.DTOs.LocationEposDTO;
import com.qa.citizen.rest.DTOs.WhereaboutsDTO;

@Service
public class WhereaboutsDTOService {

	CitizenService citizenService;
	PeopleBankAccountService bankAccService;
	BankcardService bankCardService;
	AtmTransactionService atmTransactionService;
	AtmPointService atmPointService;
	LocationAtmDTOService locationAtmDtoService;
	LocationEposDTOService locationEposDtoService;
	EposTransactionsService eposTransactionService;

	public WhereaboutsDTOService(CitizenService citizenService, PeopleBankAccountService bankAccService,
			BankcardService bankCardService, AtmTransactionService atmTransactionService,
			AtmPointService atmPointService, LocationAtmDTOService locationAtmDtoService,
			LocationEposDTOService locationEposDtoService, EposTransactionsService eposTransactionService) {
		super();
		this.citizenService = citizenService;
		this.bankAccService = bankAccService;
		this.bankCardService = bankCardService;
		this.atmTransactionService = atmTransactionService;
		this.atmPointService = atmPointService;
		this.locationAtmDtoService = locationAtmDtoService;
		this.locationEposDtoService = locationEposDtoService;
		this.eposTransactionService = eposTransactionService;
	}

	public List<WhereaboutsDTO> getWhereabouts(Citizen citizen) {
		PeopleBankAccount bankAcc = new PeopleBankAccount();
		bankAcc.setForenames(citizen.getForenames());
		bankAcc.setSurname(citizen.getSurname());
		bankAcc.setDateOfBirth(citizen.getDateOfBirth());
		bankAcc.setHomeAddress(citizen.getHomeAddress());

		List<PeopleBankAccount> foundBankAccs = this.bankAccService.getBankAccounts(bankAcc);

		List<WhereaboutsDTO> dtos = new ArrayList<>();

		for (PeopleBankAccount bAcc : foundBankAccs) {
			WhereaboutsDTO whereAboutsDTO = new WhereaboutsDTO();
			Long bankAccountId = bAcc.getBankAccountId();
			whereAboutsDTO.setBankAccountId(bankAccountId);
			Bankcard bankCard = this.bankCardService.findByBankAccountId(bankAccountId);
			whereAboutsDTO.setCardNumber(bankCard.getCardNumber());
			List<LocationAtmDTO> locationAtmDtoList = new ArrayList<>();
			List<LocationEposDTO> locationEposDtoList = new ArrayList<>();
			List<AtmTransaction> atmTransactionList = this.atmTransactionService.getAtmTransactionsByCard(bankCard);
			List<EposTransactions> eposTransactionList = this.eposTransactionService
					.getEposTransactionsByCard(bankCard.getCardNumber());
			locationAtmDtoList = this.locationAtmDtoService.getLocationAtmDTOList(atmTransactionList);
			locationEposDtoList = this.locationEposDtoService.getLocationEposDTOList(eposTransactionList);

			whereAboutsDTO.setLocationATMDTOList(locationAtmDtoList);
			whereAboutsDTO.setLocationEposDTOList(locationEposDtoList);

			dtos.add(whereAboutsDTO);
		}

		return dtos;
	}

}
