package com.qa.citizen.rest;

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
import com.qa.citizen.rest.DTOs.MobileCallRecordsDTO;
import com.qa.citizen.rest.DTOs.PeopleMobileDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads the context
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PeopleMobileControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	public String createReceivedCitizenAsJSON() throws Exception {

		// get passed something close to a citizen object
		// create passed Citizen
		Citizen passedCitizen = new Citizen();
		passedCitizen.setForenames("Michael Shane");
		passedCitizen.setSurname("Cochrane");

		// convert passed citizen object to json string
		String passedCitizenAsJSON = this.mapper.writeValueAsString(passedCitizen);

		return passedCitizenAsJSON;

	}

	// PeopleMobileControllerIntegrationTest
	@Test
	public void testGetAllCitizenPhoneInformationDTO() throws Exception {

		// build a mock request
		RequestBuilder mockRequest = post("/getMatchingBankAccounts/").contentType(MediaType.APPLICATION_JSON)
				.content(createReceivedCitizenAsJSON());

		// return a list of PeopleMobileDTO objects that match the citizen object
		List<PeopleMobileDTO> peopleMobileDTOList = new ArrayList<PeopleMobileDTO>();

		Set<MobileCallRecordsDTO> mobileCallRecords = new HashSet<MobileCallRecordsDTO>();
		MobileCallRecordsDTO returnedMobileCallRecordsDTO = new MobileCallRecordsDTO("2015-05-02T15:31:13.335",
				"07700 098484", 0L, "07700 192766", "Mathew Terry James");
		mobileCallRecords.add(returnedMobileCallRecordsDTO);

		PeopleMobileDTO returnedPeopleMobileDTO = new PeopleMobileDTO("07700 098484", "O2", mobileCallRecords);
		peopleMobileDTOList.add(returnedPeopleMobileDTO);

		// convert returned list to json
		String returnedListAsJSON = this.mapper.writeValueAsString(peopleMobileDTOList);

		// check status is 200 - OK
		ResultMatcher matchStatus = status().isOk();

		// check that response body is correct
		ResultMatcher matchBody = content().json(returnedListAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

}
