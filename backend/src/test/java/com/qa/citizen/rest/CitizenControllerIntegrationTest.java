package com.qa.citizen.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads the context
@AutoConfigureMockMvc
@ActiveProfiles("prod")
public class CitizenControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testGetMatchingCitizens() throws Exception {

		// get passed something close to a citizen object
		// create passed Citizen
		Citizen passedCitizen = new Citizen();
		passedCitizen.setForenames("Michael Shane");
		passedCitizen.setSurname("Cochrane");

		// convert passed citizen object to json string
		String passedCitizenAsJSON = this.mapper.writeValueAsString(passedCitizen);

		// build a mock request
		RequestBuilder mockRequest = post("/getMatchingCitizens/").contentType(MediaType.APPLICATION_JSON)
				.content(passedCitizenAsJSON);

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

}
