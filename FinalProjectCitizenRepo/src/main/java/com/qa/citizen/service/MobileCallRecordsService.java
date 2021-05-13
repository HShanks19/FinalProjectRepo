package com.qa.citizen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.citizen.domain.MobileCallRecords;
import com.qa.citizen.repo.MobileCallRecordsRepo;

@Service
public class MobileCallRecordsService {

	private MobileCallRecordsRepo repo;
	
	public MobileCallRecordsService(MobileCallRecordsRepo repo) {
		super();
		this.repo = repo;
	}
	
	public List<MobileCallRecords> getCallsByPhoneNumber(String callerMSISDN) {
		List<MobileCallRecords> mobileCallRecords = this.repo.findByCallerMSISDN(callerMSISDN);
		return mobileCallRecords;
	}

}
