package com.qa.citizen.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.qa.citizen.domain.MobileCallRecords;
import com.qa.citizen.domain.PeopleMobile;
import com.qa.citizen.repo.PeopleMobileRepo;
import com.qa.citizen.rest.DTOs.MobileCallRecordsDTO;
import com.qa.citizen.rest.DTOs.PeopleMobileDTO;

@Service
public class PeopleMobileService {

	private PeopleMobileRepo repo;

	public PeopleMobileService(PeopleMobileRepo repo) {
		super();
		this.repo = repo;
	}

	public PeopleMobile getCitizen(String phoneNumber) {
		return this.repo.findByPhoneNumber(phoneNumber);
	}

	public List<PeopleMobile> sortAndFilterPeopleMobile(PeopleMobile peopleMobile) {
		return this.repo.findAll(Example.of(peopleMobile));
	}
	
	private MobileCallRecordsDTO mapToDTO(MobileCallRecords mobileCallRecords) {
		MobileCallRecordsDTO mobileCallRecordsDTO = new MobileCallRecordsDTO();

		PeopleMobile callerMobile = mobileCallRecords.getCallerMSISDN();
		String receiverMobile = mobileCallRecords.getReceiverMSISDN();
		PeopleMobile receiverInformation = this.repo.findByPhoneNumber(receiverMobile);
		if (receiverInformation!=null) {
			String receiverName = receiverInformation.getForenames() + " " + receiverInformation.getSurname();
			mobileCallRecordsDTO.setReceiverName(receiverName);
		}
		
		mobileCallRecordsDTO.setTimestamp(mobileCallRecords.getTimestamp());
		mobileCallRecordsDTO.setCallerMSISDN(callerMobile.getPhoneNumber());
		mobileCallRecordsDTO.setCallCellTowerId(mobileCallRecords.getCallCellTowerId());
		mobileCallRecordsDTO.setReceiverMSISDN(receiverMobile);	
		
		return mobileCallRecordsDTO;
	}
	
	private PeopleMobileDTO mapToDTO(PeopleMobile peopleMobile) {
		PeopleMobileDTO dto = new PeopleMobileDTO();
		dto.setPhoneNumber(peopleMobile.getPhoneNumber());
		dto.setNetwork(peopleMobile.getNetwork());

		Set<MobileCallRecordsDTO> mobileCallRecordsDTOs = new HashSet<>();

		for (MobileCallRecords mobileCallRecords : peopleMobile.getMobileCallRecords()) {
			MobileCallRecordsDTO mobileCallRecordsDTO = this.mapToDTO(mobileCallRecords);
			mobileCallRecordsDTOs.add(mobileCallRecordsDTO);
		}

		dto.setMobileCallRecords(mobileCallRecordsDTOs);
		
		return dto;
	}
	
	public Set<PeopleMobileDTO> getDTO(PeopleMobile peopleMobile) {
		List<PeopleMobile> found = this.repo.findAll(Example.of(peopleMobile));
		Set<PeopleMobileDTO> returnList = new HashSet<>();
		for (int i = 0; i < found.size(); i++) {
			PeopleMobile current = found.get(i);
			PeopleMobileDTO dto = this.mapToDTO(current);
			returnList.add(dto);
        }
		return returnList;
	}

	public List<PeopleMobile> getMobileByCitizen(String forenames, String surname, String dob) {
		return this.repo.findByForenamesAndSurnameAndDateOfBirth(forenames, surname, dob);
	}

}
