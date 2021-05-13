package com.qa.citizen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.Bankcard;
import com.qa.citizen.repo.BankcardRepo;

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

}
