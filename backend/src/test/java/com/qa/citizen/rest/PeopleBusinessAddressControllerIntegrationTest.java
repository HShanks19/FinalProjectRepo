package com.qa.citizen.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.citizen.domain.PeopleBusinessAddress;
import com.qa.citizen.service.IntegrationTestService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads the context
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PeopleBusinessAddressControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private IntegrationTestService service;

	@Test
	public void testGetWorkplaceByName() throws Exception {
		RequestBuilder mockRequest = request(HttpMethod.GET, "/getBusiness/" + "Michael Shane Cochrane");

		// Expects PeopleBusinessAddress Object
		PeopleBusinessAddress returnedPeopleBusinessAddress = new PeopleBusinessAddress("Michael Shane Cochrane",
				"37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "Wash and Dry", "Seamoor Road, BH4 9AE");

		String returnedPeopleBusinessAddressAsJSON = this.mapper.writeValueAsString(returnedPeopleBusinessAddress);

		// check status is 200 - OK
		ResultMatcher matchStatus = status().isOk();

		// check that response body is correct User
		ResultMatcher matchBody = content().json(returnedPeopleBusinessAddressAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	public void testGetAllBusinessAddressInformation() throws Exception {

		// passed businessAddress object
		PeopleBusinessAddress passedPeopleBusinessAddress = new PeopleBusinessAddress("Michael Shane Cochrane",
				"37 SPUR HILL AVENUE, POOLE, BH14 9PJ", "1955-09-25", "Wash and Dry", "Seamoor Road, BH4 9AE");

		String peopleBusinessAddressObjectAsJSON = this.mapper.writeValueAsString(passedPeopleBusinessAddress);

		// build a mock request
		RequestBuilder mockRequest = post("/getAllBusinessAddressInformation/").contentType(MediaType.APPLICATION_JSON)
				.content(peopleBusinessAddressObjectAsJSON);

		List<PeopleBusinessAddress> returnedPeopleBusinessAddressList = new ArrayList<>();
		returnedPeopleBusinessAddressList.add(passedPeopleBusinessAddress);

		String returnedListAsJSON = this.mapper.writeValueAsString(returnedPeopleBusinessAddressList);

		// check status is 200 - OK
		ResultMatcher matchStatus = status().isOk();

		// check that response body is correct User
		ResultMatcher matchBody = content().json(returnedListAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

}
