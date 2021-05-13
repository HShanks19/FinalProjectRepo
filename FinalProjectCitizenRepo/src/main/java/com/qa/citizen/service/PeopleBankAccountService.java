package com.qa.citizen.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.PeopleBankAccount;
import com.qa.citizen.repo.PeopleBankAccountRepo;

@Service
public class PeopleBankAccountService {

	private PeopleBankAccountRepo repo;
	
	public PeopleBankAccountService(PeopleBankAccountRepo repo) {
		super();
		this.repo = repo;
	}
	
	//currently not working (No Value Present)
	public PeopleBankAccount getPeopleBankAccountById(Long id) {
		Optional<PeopleBankAccount> optPeopleBankAccount = this.repo.findById(id);
		return optPeopleBankAccount.get();
	}

}
