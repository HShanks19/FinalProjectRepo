package com.qa.citizen.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.domain.MobileCallRecords;
import com.qa.citizen.domain.PeopleBusinessAddress;
import com.qa.citizen.domain.PeopleMobile;
import com.qa.citizen.domain.VehicleRegistration;
import com.qa.citizen.repo.CitizenRepo;
import com.qa.citizen.repo.PeopleMobileRepo;
import com.qa.citizen.rest.DTOs.AssociatesDTO;
import com.qa.citizen.rest.DTOs.CitizenDTO;
import com.qa.citizen.rest.DTOs.ColleaguesDTO;
import com.qa.citizen.rest.DTOs.HouseholdDTO;
import com.qa.citizen.rest.DTOs.MobileCallRecordsDTO;
import com.qa.citizen.rest.DTOs.PeopleMobileDTO;
import com.qa.citizen.rest.DTOs.VehicleRegistrationDTO;

@Service
public class CitizenService {

	private CitizenRepo repo;
	
	private PeopleMobileRepo receiverRepo;

	private PeopleMobileService peopleMobileService;

	private VehicleRegistrationService vehicleRegistrationService;
	
	private PeopleBusinessAddressService peopleBusinessAddressService;
	
	private MobileCallRecordsService mobileCallRecordsService;
	
	public CitizenService(CitizenRepo repo, PeopleMobileService peopleMobileService,
			VehicleRegistrationService vehicleRegistrationService, PeopleBusinessAddressService peopleBusinessAddressService, MobileCallRecordsService mobileCallRecordsService, PeopleMobileRepo receiverRepo) {
		super();
		this.repo = repo;
		this.peopleMobileService = peopleMobileService;
		this.vehicleRegistrationService = vehicleRegistrationService;
		this.peopleBusinessAddressService = peopleBusinessAddressService;
		this.mobileCallRecordsService = mobileCallRecordsService;
		this.receiverRepo = receiverRepo;
	}

	public List<Citizen> getCitizen() {
		return this.repo.findAll();
	}
	
	public List<Citizen> getByAddress(String Address) {
		return this.repo.findByHomeAddress(Address);
	}

	public Citizen getCitizenById(Long id) {
		Optional<Citizen> optCitizen = this.repo.findById(id);
		return optCitizen.get();
	}

	public List<Citizen> sortAndFilterCitizens(Citizen citizen) {
		return this.repo.findAll(Example.of(citizen));
	}


	public List<VehicleRegistrationDTO> mapToVehicleRegistrationDTO(List<VehicleRegistration> vehicleRegistration) {

		List<VehicleRegistrationDTO> vehicleRegistrationDTOList = new ArrayList<>();

		for (VehicleRegistration foundvehicle : vehicleRegistration) {
			VehicleRegistrationDTO vehicleRegistrationDTO = new VehicleRegistrationDTO();
			vehicleRegistrationDTO.setColour(foundvehicle.getColour());
			vehicleRegistrationDTO.setMake(foundvehicle.getMake());
			vehicleRegistrationDTO.setModel(foundvehicle.getModel());
			vehicleRegistrationDTO.setRegistrationDate(foundvehicle.getRegistrationDate());
			vehicleRegistrationDTO.setVehicleRegistrationNo(foundvehicle.getVehicleRegistrationNo());

			vehicleRegistrationDTOList.add(vehicleRegistrationDTO);

		}

		return vehicleRegistrationDTOList;

	}

	public List<PeopleMobileDTO> mapToPeopleMobileDTO(List<PeopleMobile> peopleMobile) {

		List<PeopleMobileDTO> peopleMobileDTOList = new ArrayList<>();

		for (PeopleMobile foundMobile : peopleMobile) {
			PeopleMobileDTO peopleMobileDTO = new PeopleMobileDTO();
			peopleMobileDTO.setPhoneNumber(foundMobile.getPhoneNumber());
			peopleMobileDTO.setNetwork(foundMobile.getNetwork());
			peopleMobileDTOList.add(peopleMobileDTO);

		}

		return peopleMobileDTOList;

	}

	public List<CitizenDTO> mapToCitizenDTO(List<Citizen> citizenList) {
		List<CitizenDTO> foundCitizens = new ArrayList<>();

		for (Citizen foundCitizen : citizenList) {
			CitizenDTO citizenDTO = new CitizenDTO();
			citizenDTO.setForenames(foundCitizen.getForenames());
			citizenDTO.setSurname(foundCitizen.getSurname());
			citizenDTO.setHomeAddress(foundCitizen.getHomeAddress());
			citizenDTO.setDateOfBirth(foundCitizen.getDateOfBirth());
			citizenDTO.setPlaceOfBirth(foundCitizen.getPlaceOfBirth());
			citizenDTO.setSex(foundCitizen.getSex());

			List<PeopleMobile> peopleMobile = this.peopleMobileService.getMobileByCitizen(foundCitizen.getForenames(),
					foundCitizen.getSurname(), foundCitizen.getDateOfBirth());

			List<VehicleRegistration> vehicleRegistration = this.vehicleRegistrationService.getVehicleByCitizen(
					foundCitizen.getForenames(), foundCitizen.getSurname(), foundCitizen.getDateOfBirth());

			citizenDTO.setCitizensMobileNumbers(this.mapToPeopleMobileDTO(peopleMobile));
			citizenDTO.setCitizensVehicles(this.mapToVehicleRegistrationDTO(vehicleRegistration));

			foundCitizens.add(citizenDTO);
		}

		return foundCitizens;
	}

	public List<CitizenDTO> sortAndFilterCitizensMapToDTO(Citizen citizen) {
		List<Citizen> citizenList = this.repo.findAll(Example.of(citizen));
		return this.mapToCitizenDTO(citizenList);
	}
	
	public List<AssociatesDTO> mapToAssociatesDTO(List<Citizen> citizenList) {
		List<AssociatesDTO> foundAssociates = new ArrayList<>();

		for (Citizen foundCitizen : citizenList) {
			AssociatesDTO associatesDTO = new AssociatesDTO();
			PeopleBusinessAddress workplace = this.peopleBusinessAddressService.getWorkplaceByName(foundCitizen.getForenames() + " " + foundCitizen.getSurname());
			associatesDTO.setBusinessName(workplace.getBusinessName());
			associatesDTO.setBusinessAddress(workplace.getBusinessAddress());
			String householdAddress = foundCitizen.getHomeAddress();
			
			List<PeopleMobile> peopleMobile = this.peopleMobileService.getMobileByCitizen(foundCitizen.getForenames(),
					foundCitizen.getSurname(), foundCitizen.getDateOfBirth());
			
			associatesDTO.setCallRecords(this.mapToPeopleDTO(peopleMobile));
			
			List<Citizen> householdMembers = getByAddress(householdAddress);

			associatesDTO.setHousehold(this.mapToHouseholdDTO(householdMembers));
			
			List<PeopleBusinessAddress> colleagues = this.peopleBusinessAddressService.getByBusinessAddress(workplace.getBusinessAddress());

			associatesDTO.setColleagues(this.mapToColleaguesDTO(colleagues));
			
			foundAssociates.add(associatesDTO);
		}

		return foundAssociates;
	}
	
	private List<ColleaguesDTO> mapToColleaguesDTO(List<PeopleBusinessAddress> colleagues) {
		List<ColleaguesDTO> colleaguesDTOList = new ArrayList<>();

		for (PeopleBusinessAddress foundColleague : colleagues) {
			ColleaguesDTO colleagueDTO = new ColleaguesDTO();
			colleagueDTO.setPersonName(foundColleague.getPersonName());
			colleagueDTO.setDateOfBirth(foundColleague.getDateOfBirth());
			colleaguesDTOList.add(colleagueDTO);

		}

		return colleaguesDTOList;
	}

	private List<HouseholdDTO> mapToHouseholdDTO(List<Citizen> householdMembers) {
		List<HouseholdDTO> householdDTOList = new ArrayList<>();

		for (Citizen foundCitizen : householdMembers) {
			HouseholdDTO householdDTO = new HouseholdDTO();
			householdDTO.setPersonName(foundCitizen.getForenames() + foundCitizen.getSurname());
			householdDTO.setDateOfBirth(foundCitizen.getDateOfBirth());
			householdDTOList.add(householdDTO);

		}

		return householdDTOList;
	}
	
	private MobileCallRecordsDTO mapToDTO(MobileCallRecords mobileCallRecords) {
		MobileCallRecordsDTO mobileCallRecordsDTO = new MobileCallRecordsDTO();

		String callerMobile = mobileCallRecords.getCallerMSISDN();
		String receiverMobile = mobileCallRecords.getReceiverMSISDN();
		PeopleMobile receiverInformation = this.receiverRepo.findByPhoneNumber(receiverMobile);
		if (receiverInformation!=null) {
			String receiverName = receiverInformation.getForenames() + " " + receiverInformation.getSurname();
			mobileCallRecordsDTO.setReceiverName(receiverName);
		}
		mobileCallRecordsDTO.setTimestamp(mobileCallRecords.getTimestamp());
		mobileCallRecordsDTO.setCallerMSISDN(callerMobile);
		mobileCallRecordsDTO.setCallCellTowerId(mobileCallRecords.getCallCellTowerId());
		mobileCallRecordsDTO.setReceiverMSISDN(receiverMobile);	
		
		return mobileCallRecordsDTO;
	}
	
	public List<PeopleMobileDTO> mapToPeopleDTO(List<PeopleMobile> peopleMobile) {
		List<PeopleMobileDTO> callHistory = new ArrayList<>();
		
		for (PeopleMobile receiver : peopleMobile) {
			PeopleMobileDTO dto = new PeopleMobileDTO();
			dto.setPhoneNumber(receiver.getPhoneNumber());
			dto.setNetwork(receiver.getNetwork());
	
			Set<MobileCallRecordsDTO> mobileCallRecordsDTOs = new HashSet<>();
			
			List<MobileCallRecords> mobileCallRecordsNew = this.mobileCallRecordsService.getCallsByPhoneNumber(receiver.getPhoneNumber());
	
			for (MobileCallRecords mobileCallRecords : mobileCallRecordsNew) {
				MobileCallRecordsDTO mobileCallRecordsDTO = this.mapToDTO(mobileCallRecords);
				mobileCallRecordsDTOs.add(mobileCallRecordsDTO);
			}
	
			dto.setMobileCallRecords(mobileCallRecordsDTOs);
			
			callHistory.add(dto);
		}
		
		return callHistory;
	}

	public List<AssociatesDTO> sortAndFilterCitizensMapToAssociatesDTO(Citizen citizen) {
		List<Citizen> citizenList = this.repo.findAll(Example.of(citizen));
		return this.mapToAssociatesDTO(citizenList);
	}

}
