package com.qa.citizen.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;

import com.qa.citizen.domain.Citizen;
import com.qa.citizen.domain.PeopleMobile;
import com.qa.citizen.domain.VehicleRegistration;
import com.qa.citizen.repo.CitizenRepo;
import com.qa.citizen.rest.DTOs.CitizenDTO;
import com.qa.citizen.rest.DTOs.MobileCallRecordsDTO;
import com.qa.citizen.rest.DTOs.PeopleMobileDTO;
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

	@Test
	public void testMapToPeopleMobileDTO() {
		List<PeopleMobile> passedPeopleMobileList = new ArrayList<>();
		PeopleMobile peopleMobile1 = new PeopleMobile("Michael Shane", "Cochrane", "1955-09-25", "37 SPUR HILL AVENUE",
				"POOLE", "BH14 9PJ", "07700 098484", "O2");
		passedPeopleMobileList.add(peopleMobile1);

		Set<MobileCallRecordsDTO> mobileCallRecords = new HashSet<MobileCallRecordsDTO>();
		MobileCallRecordsDTO returnedMobileCallRecordsDTO1 = new MobileCallRecordsDTO("2015-05-02T15:31:13.335",
				"07700 098484", 0L, "07700 192766");
		mobileCallRecords.add(returnedMobileCallRecordsDTO1);

		List<PeopleMobileDTO> returnedPeopleMobileDTOList = new ArrayList<>();
		PeopleMobileDTO returnedPeopleMobileDTO1 = new PeopleMobileDTO();
		returnedPeopleMobileDTO1.setPhoneNumber("07700 098484");
		returnedPeopleMobileDTO1.setNetwork("O2");
		returnedPeopleMobileDTOList.add(returnedPeopleMobileDTO1);

		assertThat(returnedPeopleMobileDTOList)
				.isEqualTo(this.citizenService.mapToPeopleMobileDTO(passedPeopleMobileList))
				.containsExactly(returnedPeopleMobileDTO1);

	}

	@Test
	public void testMapToCitizenDTO() {

		List<Citizen> passedCitizenList = new ArrayList<>();
		Citizen michael = new Citizen(9171862863L, "Michael Shane", "Cochrane", "37 SPUR HILL AVENUE, POOLE, BH14 9PJ",
				"1955-09-25", "LONDON", "Male");
		passedCitizenList.add(michael);

		List<CitizenDTO> returnedCitizenDTOList = new ArrayList<>();
		CitizenDTO returnedCitizenDTO = new CitizenDTO("Michael Shane", "Cochrane",
				"37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "LONDON", "Male");

		List<PeopleMobileDTO> citizensMobileNumbers = new ArrayList<PeopleMobileDTO>();
		PeopleMobileDTO returnedPeopleMobileDTO = new PeopleMobileDTO();
		returnedPeopleMobileDTO.setPhoneNumber("07700 098484");
		returnedPeopleMobileDTO.setNetwork("O2");
		citizensMobileNumbers.add(returnedPeopleMobileDTO);
		returnedCitizenDTO.setCitizensMobileNumbers(citizensMobileNumbers);

		List<VehicleRegistrationDTO> returnedVehicleRegistrationDTOList = new ArrayList<VehicleRegistrationDTO>();
		VehicleRegistrationDTO returnedVehicleRegistrationDTO = new VehicleRegistrationDTO("1999-01-16", "UN28 EIN",
				"Toyota", "Yaris", "red");
		returnedVehicleRegistrationDTOList.add(returnedVehicleRegistrationDTO);
		returnedCitizenDTO.setCitizensVehicles(returnedVehicleRegistrationDTOList);

		returnedCitizenDTOList.add(returnedCitizenDTO);

		assertThat(returnedCitizenDTOList).isEqualTo(this.citizenService.mapToCitizenDTO(passedCitizenList));

	}

	@Test
	public void TestSortAndFilterCitizensMapToDTO() {
		Citizen citizenSentByUser = new Citizen();
		citizenSentByUser.setHomeAddress("37 SPUR HILL AVENUE, POOLE, BH14 9PJ");
		List<Citizen> returnedCitizenList = new ArrayList<>();
		Citizen foundCitizen = new Citizen(9171862863L, "Michael Shane", "Cochrane",
				"37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "LONDON", "Male");
		returnedCitizenList.add(foundCitizen);

		List<CitizenDTO> returnedCitizenDTOList = new ArrayList<CitizenDTO>();
		CitizenDTO returnedCitizenDTO = new CitizenDTO("Michael Shane", "Cochrane",
				"37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "LONDON", "Male");
		returnedCitizenDTOList.add(returnedCitizenDTO);

		Mockito.when(this.citizenRepo.findAll(Example.of(citizenSentByUser))).thenReturn(returnedCitizenList);

	}

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
