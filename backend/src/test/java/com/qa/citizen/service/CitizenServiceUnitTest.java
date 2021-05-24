package com.qa.citizen.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.domain.VehicleRegistration;
import com.qa.citizen.repo.CitizenRepo;
import com.qa.citizen.rest.DTOs.VehicleRegistrationDTO;

@SpringBootTest
@ActiveProfiles("test")
public class CitizenServiceUnitTest {

	@Autowired
	private CitizenService citizenService;

	@MockBean
	private CitizenRepo citizenRepo;

	@Test
	public void testGetCitizen() {

		List<Citizen> returnedCitizenList = new ArrayList<>();

		Citizen michael = new Citizen(9171862863L, "Michael Shane", "Cochrane", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1955-09-25", "LONDON", "Male");
		Citizen mathew = new Citizen(1647328256L, "Mathew Terry", "James", "8 SUMMERFIELDS, BOURNEMOUTH, BH7 7RN",
				"1958-08-18", "COATBRIDGE", "Male");
		Citizen colin = new Citizen(3554464415L, "Colin", "Parsons", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1994-01-19", "MANCHESTER", "Male");

		returnedCitizenList.add(michael);
		returnedCitizenList.add(mathew);
		returnedCitizenList.add(colin);

		Mockito.when(this.citizenRepo.findAll()).thenReturn(returnedCitizenList);

		assertThat(this.citizenService.getCitizen()).isEqualTo(returnedCitizenList).containsExactly(michael, mathew,
				colin);

	}

	@Test
	public void testGetCitizenByAddress() {

		String representAddressParamPassed = "37 SPUR HILL AVENUE, POOLE, BH14 9PJ";

		List<Citizen> listOfCitizenMatchingAddressedPassed = new ArrayList<Citizen>();
		Citizen michael = new Citizen(9171862863L, "Michael Shane", "Cochrane", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1955-09-25", "LONDON", "Male");
		Citizen colin = new Citizen(3554464415L, "Colin", "Parsons", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1994-01-19", "MANCHESTER", "Male");

		listOfCitizenMatchingAddressedPassed.add(michael);
		listOfCitizenMatchingAddressedPassed.add(colin);

		Mockito.when(this.citizenRepo.findByHomeAddress(representAddressParamPassed))
				.thenReturn(listOfCitizenMatchingAddressedPassed);

		assertThat(this.citizenService.getByAddress(representAddressParamPassed))
				.isEqualTo(listOfCitizenMatchingAddressedPassed).containsExactly(michael, colin);
		;

	}

	@Test
	public void testGetCitizenById() {

		Long id = 9171862863L;

		Citizen returnedCitizen = new Citizen(9171862863L, "Michael Shane", "Cochrane",
				"37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "LONDON", "Male");

		Mockito.when(this.citizenRepo.findById(id)).thenReturn(Optional.of(returnedCitizen));

		assertThat(this.citizenService.getCitizenById(id)).isEqualTo(returnedCitizen);

	}

	@Test
	public void testSortAndFilterCitizens() {

		Citizen citizenSentByUser = new Citizen();
		citizenSentByUser.setHomeAddress("37 SPUR HILL AVENUE, POOLE, BH14 9PJ");

		List<Citizen> returnedCitizens = new ArrayList<Citizen>();

		Citizen michael = new Citizen(9171862863L, "Michael Shane", "Cochrane", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1955-09-25", "LONDON", "Male");
		Citizen colin = new Citizen(3554464415L, "Colin", "Parsons", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1994-01-19", "MANCHESTER", "Male");

		returnedCitizens.add(michael);
		returnedCitizens.add(colin);

		Mockito.when(this.citizenRepo.findAll(Example.of(citizenSentByUser))).thenReturn(returnedCitizens);

		assertThat(this.citizenService.sortAndFilterCitizens(citizenSentByUser)).isEqualTo(returnedCitizens)
				.containsExactly(michael, colin);

	}

	@Test
	public void testMapToVehicleRegistrationDTO() {

		List<VehicleRegistration> passedVehicleRegistrationList = new ArrayList<>();
		VehicleRegistration vehicleReg = new VehicleRegistration(131240L, "1999-01-16", "UN28 EIN", "Toyota", "Yaris",
				"red", "Michael Shane", "Cochrane", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25",
				"COCHR509255MS9RM 41");
		passedVehicleRegistrationList.add(vehicleReg);

		List<VehicleRegistrationDTO> returnedVehicleRegistrationDTOList = new ArrayList<VehicleRegistrationDTO>();
		VehicleRegistrationDTO returnedVehicleRegistrationDTO = new VehicleRegistrationDTO("1999-01-16", "UN28 EIN",
				"Toyota", "Yaris", "red");
		returnedVehicleRegistrationDTOList.add(returnedVehicleRegistrationDTO);

		assertThat(returnedVehicleRegistrationDTOList)
				.isEqualTo(this.citizenService.mapToVehicleRegistrationDTO(passedVehicleRegistrationList));

	}

//	public List<VehicleRegistrationDTO> mapToVehicleRegistrationDTO(List<VehicleRegistration> vehicleRegistration) {
//
//		List<VehicleRegistrationDTO> vehicleRegistrationDTOList = new ArrayList<>();
//
//		for (VehicleRegistration foundvehicle : vehicleRegistration) {
//			VehicleRegistrationDTO vehicleRegistrationDTO = new VehicleRegistrationDTO();
//			vehicleRegistrationDTO.setColour(foundvehicle.getColour());
//			vehicleRegistrationDTO.setMake(foundvehicle.getMake());
//			vehicleRegistrationDTO.setModel(foundvehicle.getModel());
//			vehicleRegistrationDTO.setRegistrationDate(foundvehicle.getRegistrationDate());
//			vehicleRegistrationDTO.setVehicleRegistrationNo(foundvehicle.getVehicleRegistrationNo());
//
//			vehicleRegistrationDTOList.add(vehicleRegistrationDTO);
//
//		}
//
//		return vehicleRegistrationDTOList;
//
//	}
//
//	public List<PeopleMobileDTO> mapToPeopleMobileDTO(List<PeopleMobile> peopleMobile) {
//
//		List<PeopleMobileDTO> peopleMobileDTOList = new ArrayList<>();
//
//		for (PeopleMobile foundMobile : peopleMobile) {
//			PeopleMobileDTO peopleMobileDTO = new PeopleMobileDTO();
//			peopleMobileDTO.setPhoneNumber(foundMobile.getPhoneNumber());
//			peopleMobileDTO.setNetwork(foundMobile.getNetwork());
//			peopleMobileDTOList.add(peopleMobileDTO);
//
//		}
//
//		return peopleMobileDTOList;
//
//	}
//
//	public List<CitizenDTO> mapToCitizenDTO(List<Citizen> citizenList) {
//		List<CitizenDTO> foundCitizens = new ArrayList<>();
//
//		for (Citizen foundCitizen : citizenList) {
//			CitizenDTO citizenDTO = new CitizenDTO();
//			citizenDTO.setForenames(foundCitizen.getForenames());
//			citizenDTO.setSurname(foundCitizen.getSurname());
//			citizenDTO.setHomeAddress(foundCitizen.getHomeAddress());
//			citizenDTO.setDateOfBirth(foundCitizen.getDateOfBirth());
//			citizenDTO.setPlaceOfBirth(foundCitizen.getPlaceOfBirth());
//			citizenDTO.setSex(foundCitizen.getSex());
//
//			List<PeopleMobile> peopleMobile = this.peopleMobileService.getMobileByCitizen(foundCitizen.getForenames(),
//					foundCitizen.getSurname(), foundCitizen.getDateOfBirth());
//
//			List<VehicleRegistration> vehicleRegistration = this.vehicleRegistrationService.getVehicleByCitizen(
//					foundCitizen.getForenames(), foundCitizen.getSurname(), foundCitizen.getDateOfBirth());
//
//			citizenDTO.setCitizensMobileNumbers(this.mapToPeopleMobileDTO(peopleMobile));
//			citizenDTO.setCitizensVehicles(this.mapToVehicleRegistrationDTO(vehicleRegistration));
//
//			foundCitizens.add(citizenDTO);
//		}
//
//		return foundCitizens;
//	}
//
//	public List<CitizenDTO> sortAndFilterCitizensMapToDTO(Citizen citizen) {
//		List<Citizen> citizenList = this.repo.findAll(Example.of(citizen));
//		return this.mapToCitizenDTO(citizenList);
//	}
//	
//	public List<AssociatesDTO> mapToAssociatesDTO(List<Citizen> citizenList) {
//		List<AssociatesDTO> foundAssociates = new ArrayList<>();
//
//		for (Citizen foundCitizen : citizenList) {
//			AssociatesDTO associatesDTO = new AssociatesDTO();
//			PeopleBusinessAddress workplace = this.peopleBusinessAddressService.getWorkplaceByName(foundCitizen.getForenames() + " " + foundCitizen.getSurname());
//			associatesDTO.setBusinessName(workplace.getBusinessName());
//			associatesDTO.setBusinessAddress(workplace.getBusinessAddress());
//			String householdAddress = foundCitizen.getHomeAddress();
//			
//			List<PeopleMobile> peopleMobile = this.peopleMobileService.getMobileByCitizen(foundCitizen.getForenames(),
//					foundCitizen.getSurname(), foundCitizen.getDateOfBirth());
//			
//			associatesDTO.setCallRecords(this.mapToPeopleDTO(peopleMobile));
//			
//			List<Citizen> householdMembers = getByAddress(householdAddress);
//
//			associatesDTO.setHousehold(this.mapToHouseholdDTO(householdMembers));
//			
//			List<PeopleBusinessAddress> collegues = this.peopleBusinessAddressService.getByBusinessAddress(workplace.getBusinessAddress());
//
//			associatesDTO.setCollegues(this.mapToColleguesDTO(collegues));
//			
//			foundAssociates.add(associatesDTO);
//		}
//
//		return foundAssociates;
//	}
//	
//	private List<ColleaguesDTO> mapToColleguesDTO(List<PeopleBusinessAddress> collegues) {
//		List<ColleaguesDTO> colleguesDTOList = new ArrayList<>();
//
//		for (PeopleBusinessAddress foundCollegue : collegues) {
//			ColleaguesDTO collegueDTO = new ColleaguesDTO();
//			collegueDTO.setPersonName(foundCollegue.getPersonName());
//			collegueDTO.setDateOfBirth(foundCollegue.getDateOfBirth());
//			colleguesDTOList.add(collegueDTO);
//
//		}
//
//		return colleguesDTOList;
//	}
//
//	private List<HouseholdDTO> mapToHouseholdDTO(List<Citizen> householdMembers) {
//		List<HouseholdDTO> householdDTOList = new ArrayList<>();
//
//		for (Citizen foundCitizen : householdMembers) {
//			HouseholdDTO householdDTO = new HouseholdDTO();
//			householdDTO.setPersonName(foundCitizen.getForenames() + foundCitizen.getSurname());
//			householdDTO.setDateOfBirth(foundCitizen.getDateOfBirth());
//			householdDTOList.add(householdDTO);
//
//		}
//
//		return householdDTOList;
//	}
//	
//	private MobileCallRecordsDTO mapToDTO(MobileCallRecords mobileCallRecords) {
//		MobileCallRecordsDTO mobileCallRecordsDTO = new MobileCallRecordsDTO();
//
//		String callerMobile = mobileCallRecords.getCallerMSISDN();
//		String receiverMobile = mobileCallRecords.getReceiverMSISDN();
//		PeopleMobile receiverInformation = this.receiverRepo.findByPhoneNumber(receiverMobile);
//		if (receiverInformation!=null) {
//			String receiverName = receiverInformation.getForenames() + " " + receiverInformation.getSurname();
//			mobileCallRecordsDTO.setReceiverName(receiverName);
//		}
//		mobileCallRecordsDTO.setTimestamp(mobileCallRecords.getTimestamp());
//		mobileCallRecordsDTO.setCallerMSISDN(callerMobile);
//		mobileCallRecordsDTO.setCallCellTowerId(mobileCallRecords.getCallCellTowerId());
//		mobileCallRecordsDTO.setReceiverMSISDN(receiverMobile);	
//		
//		return mobileCallRecordsDTO;
//	}
//	
//	public List<PeopleMobileDTO> mapToPeopleDTO(List<PeopleMobile> peopleMobile) {
//		List<PeopleMobileDTO> callHistory = new ArrayList<>();
//		
//		for (PeopleMobile receiver : peopleMobile) {
//			PeopleMobileDTO dto = new PeopleMobileDTO();
//			dto.setPhoneNumber(receiver.getPhoneNumber());
//			dto.setNetwork(receiver.getNetwork());
//	
//			Set<MobileCallRecordsDTO> mobileCallRecordsDTOs = new HashSet<>();
//			
//			List<MobileCallRecords> mobileCallRecordsNew = this.mobileCallRecordsService.getCallsByPhoneNumber(receiver.getPhoneNumber());
//	
//			for (MobileCallRecords mobileCallRecords : mobileCallRecordsNew) {
//				MobileCallRecordsDTO mobileCallRecordsDTO = this.mapToDTO(mobileCallRecords);
//				mobileCallRecordsDTOs.add(mobileCallRecordsDTO);
//			}
//	
//			dto.setMobileCallRecords(mobileCallRecordsDTOs);
//			
//			callHistory.add(dto);
//		}
//		
//		return callHistory;
//	}
//
//	public List<AssociatesDTO> sortAndFilterCitizensMapToAssociatesDTO(Citizen citizen) {
//		List<Citizen> citizenList = this.repo.findAll(Example.of(citizen));
//		return this.mapToAssociatesDTO(citizenList);
//	}

}
