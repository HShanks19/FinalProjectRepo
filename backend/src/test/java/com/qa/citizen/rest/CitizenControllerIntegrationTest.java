package com.qa.citizen.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.citizen.domain.Citizen;
import com.qa.citizen.rest.DTOs.AssociatesDTO;
import com.qa.citizen.rest.DTOs.CitizenDTO;
import com.qa.citizen.rest.DTOs.ColleaguesDTO;
import com.qa.citizen.rest.DTOs.HouseholdDTO;
import com.qa.citizen.rest.DTOs.MobileCallRecordsDTO;
import com.qa.citizen.rest.DTOs.PeopleMobileDTO;
import com.qa.citizen.rest.DTOs.VehicleRegistrationDTO;
import com.qa.citizen.service.IntegrationTestService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads the context
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CitizenControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private IntegrationTestService service;

	@Test
	public void testGetMatchingCitizens() throws Exception {

		// build a mock request
		RequestBuilder mockRequest = post("/getMatchingCitizens/").contentType(MediaType.APPLICATION_JSON)
				.content(service.createReceivedCitizenAsJSON());

		// return a list of citizen objects that match the citizen object passed
		Citizen returnedCitizen = new Citizen(9171862863L, "Michael Shane", "Cochrane",
				"37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "LONDON", "Male");
		List<Citizen> returnedCitizens = new ArrayList<>();
		returnedCitizens.add(returnedCitizen);

		// convert returned list to json
		String returnedListAsJSON = this.mapper.writeValueAsString(returnedCitizens);

		// check status is 200 - OK
		ResultMatcher matchStatus = status().isOk();

		// check that response body is correct User
		ResultMatcher matchBody = content().json(returnedListAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	public void testGetCitizensAssociates() throws Exception {

		// build a mock request
		RequestBuilder mockRequest = post("/getCitizensAssociates/").contentType(MediaType.APPLICATION_JSON)
				.content(service.createReceivedCitizenAsJSON());

		// return a list of AssociatesDTO objects that match the citizen object passed
		Set<MobileCallRecordsDTO> mobileCallRecords = new HashSet<MobileCallRecordsDTO>();
		MobileCallRecordsDTO returnedMobileCallRecordsDTO = new MobileCallRecordsDTO("2015-05-02T15:31:13.335",
				"07700 098484", 0L, "07700 192766", "Mathew Terry James");
		mobileCallRecords.add(returnedMobileCallRecordsDTO);

		List<PeopleMobileDTO> peopleMobileDTOList = new ArrayList<>();
		PeopleMobileDTO peopleMobileDTO = new PeopleMobileDTO("07700 098484", "O2", mobileCallRecords);
		peopleMobileDTOList.add(peopleMobileDTO);

		List<ColleaguesDTO> colleaguesDtoList = new ArrayList<>();
		ColleaguesDTO colleaguesDTO1 = new ColleaguesDTO("Michael Shane Cochrane", "1955-09-25");
		ColleaguesDTO colleaguesDTO2 = new ColleaguesDTO("Linda Lynda Anderson", "1959-05-06");
		colleaguesDtoList.add(colleaguesDTO1);
		colleaguesDtoList.add(colleaguesDTO2);

		List<HouseholdDTO> householdDtoList = new ArrayList<>();
		HouseholdDTO householdDTO1 = new HouseholdDTO("Colin Parsons", "1994-01-19");
		HouseholdDTO householdDTO2 = new HouseholdDTO("Michael Shane Cochrane", "1955-09-25");
		householdDtoList.add(householdDTO1);
		householdDtoList.add(householdDTO2);

		AssociatesDTO returnedAssociatesDto = new AssociatesDTO(peopleMobileDTOList, "Wash and Dry",
				"Seamoor Road, BH4 9AE", colleaguesDtoList, householdDtoList);
		List<AssociatesDTO> returnedAssociatesDTOs = new ArrayList<>();
		returnedAssociatesDTOs.add(returnedAssociatesDto);

		// convert returned list to json
		String returnedListAsJSON = this.mapper.writeValueAsString(returnedAssociatesDTOs);

		// check status is 200 - OK
		ResultMatcher matchStatus = status().isOk();

		// check that response body is correct
		ResultMatcher matchBody = content().json(returnedListAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	public void testgetBiographicalInfo() throws Exception {
		// passed a citizen id from controller

		// build a mock request
		RequestBuilder mockRequest = get("/getBiographicalInfo/" + 9171862863L);

		// expects a list of citizen DTOs
		List<CitizenDTO> citizenDTOList = new ArrayList<CitizenDTO>();

		// citizenDTO expects list of people mobile dto
		List<PeopleMobileDTO> peopleMobileDtoList = new ArrayList<PeopleMobileDTO>();
		Set<MobileCallRecordsDTO> mobileCallRecordsDTOSet = null;
		PeopleMobileDTO peopleMobileDTO = new PeopleMobileDTO("07700 098484", "O2", mobileCallRecordsDTOSet);
		peopleMobileDtoList.add(peopleMobileDTO);

		// citizenDTO expects list of VehicleRegistrationDTOs
		List<VehicleRegistrationDTO> VehicleRegistrationDTOList = new ArrayList<VehicleRegistrationDTO>();
		VehicleRegistrationDTO vehicleRegistrationDTO = new VehicleRegistrationDTO("1999-01-16", "UN28 EIN", "Toyota",
				"Yaris", "red");
		VehicleRegistrationDTOList.add(vehicleRegistrationDTO);

		CitizenDTO expectedCitizenDTO = new CitizenDTO("Michael Shane", "Cochrane",
				"37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "LONDON", "Male", peopleMobileDtoList,
				VehicleRegistrationDTOList);

		citizenDTOList.add(expectedCitizenDTO);

		// convert returned list to json
		String returnedListAsJSON = this.mapper.writeValueAsString(citizenDTOList);

		// check status is 200 - OK
		ResultMatcher matchStatus = status().isOk();

		// check that response body is correct
		ResultMatcher matchBody = content().json(returnedListAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

}
